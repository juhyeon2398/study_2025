let uploadDiv = document.querySelector(".uploadDiv");
let cloneObj = uploadDiv.firstElementChild.cloneNode(true);

const regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
const MAX_SIZE = 5242880; //5MB

const removeList = [];






function checkExtension(fileName, fileSize){
	console.log(regex.test(fileName));
	if(fileSize >= MAX_SIZE){
		alert("파일 사이즈 초과");
		return false;
	}
	if(regex.test(fileName)){
		alert("해당 종류의 파일은 업로드할 수 없습니다.");
		return false;
	}
}

let uploadResult = document.querySelector(".uploadResult ul");
const hf = document.forms[0];
function showUploadedFile(uploadResultArr){
	if(!uploadResultArr || uploadResultArr.length == 0){
		return;
	}
	if(uploadResultArr != null && uploadResultArr.length > 0){
		uploadResultArr.forEach((file,idx) =>{
			let fileCallPath = 
				encodeURIComponent(
						file.uploadPath + "/" + file.uuid + "_" + file.fileName)
			str += `<li path="${file.uploadPath}" uuid="${file.uuid}" filename="${file.fileName}">`;
			//str += 		`<a href="/download?fileName=${fileCallPath}">${file.fileName}</a>`;
			str += 		`<a>${file.fileName}</a>`;
			str += 		`<span data-file='${fileCallPath}'> X </span>`;
			str += `</li>`;
		});
	}
	
	uploadResult.innerHTML = str;
 	
}

let isBoolean = true;
let arr = "";
function showUploadedFile2(uploadResultArr,newData){
	if(!uploadResultArr || uploadResultArr.length == 0){
		return;
	}
	if(uploadResultArr != null && uploadResultArr.length > 0){
		arr = uploadResultArr;
	}
	
	let str = "";
	if(isBoolean){
		if(uploadResultArr != null && uploadResultArr.length > 0){
			uploadResultArr.forEach((file,idx) =>{
				let fileCallPath = 
					encodeURIComponent(
							file.uploadPath + "/" + file.uuid + "_" + file.fileName)
				if(isBoolean){
					str += `<li path="${file.uploadPath}" uuid="${file.uuid}" filename="${file.fileName}">`;
					//str += 		`<a href="/download?fileName=${fileCallPath}">${file.fileName}</a>`;
					str += 		`<a>${file.fileName}</a>`;
					str += 		`<span data-file='${fileCallPath}'> X </span>`;
					str += `</li>`;
				}
				
			});
			isBoolean = false;
		}
	}else{
		arr.forEach((file,idx) => {
			let fileCallPath = 
				encodeURIComponent(
						file.uploadPath + "/" + file.uuid + "_" + file.fileName)
			if(removeList != null && removeList.length > 0){
				removeList.forEach(removeEl => {
					if(removeEl.uuid !== a.uuid){
						str += `<li path="${file.uploadPath}" uuid="${file.uuid}" filename="${file.fileName}">`;
						//str += 		`<a href="/download?fileName=${fileCallPath}">${file.fileName}</a>`;
						str += 		`<a>${file.fileName}</a>`;
						str += 		`<span data-file='${fileCallPath}'> X </span>`;
						str += `</li>`;
					}
				})
			}
			
			if(newData != null && newData.length > 0){
				newData.forEach(newFile => {
					str += `<li path="${newFile.uploadPath}" uuid="${newFile.uuid}" filename="${newFile.fileName}">`;
					//str += 		`<a href="/download?fileName=${fileCallPath}">${file.fileName}</a>`;
					str += 		`<a>${newFile.fileName}</a>`;
					str += 		`<span data-file='${fileCallPath}'> X </span>`;
					str += `</li>`;
				})
			}
			
		})
	}
	
	
	uploadResult.innerHTML = str;
}


uploadResult.addEventListener("click" ,function(e){
	if(e.target.tagName == "SPAN"){
		let targetFile = e.target.getAttribute("data-file");
		if(targetFile != null && targetFile != ""){
			let str = decodeURIComponent(targetFile).split("/");
			const data = { 
					path : str[0],
					uuid : str[1].split("_")[0],	
					filename : str[1].split("_")[1]	
			}
			
			removeList.push(data);
		}
		
		let targetLi = e.target.closest('li');
		targetLi.remove();
	}
	
})
 
function hideData(){
	
	let hideStr = "";
	
	
	if(uploadResult.childNodes != null && uploadResult.childNodes.length > 0){
		uploadResult.childNodes.forEach((file, idx) => {
			
			
			let filename = file.getAttribute("filename");
			let uuid = file.getAttribute("uuid");
			let uploadPath = file.getAttribute("path");
			
			hideStr += `<input type="hidden" name="attachList[${idx}].fileName" value="${filename}"/>`
			hideStr += `<input type="hidden" name="attachList[${idx}].uuid" value="${uuid}"/>`
			hideStr += `<input type="hidden" name="attachList[${idx}].uploadPath" value="${uploadPath}"/>`
		})
	}
	
	hf.insertAdjacentHTML("beforeend", hideStr);
}



const fileInput = document.querySelector("input[type='file']");

fileInput.addEventListener("change" ,() => {
    const files = fileInput.files;
    for(let i = 0; i < files.length;i++){
    	
        let newStr = "";
        
        newStr += `<li>`;
        newStr +=     `<a>${files[i].name}</a>`;
        newStr +=     `<span> X </span>`;
        newStr += `</li>`;
        
        uploadResult.innerHTML += newStr;
    }
})

function uploadFile(){
	const formData = new FormData();
	const files = fileInput.files;
	
	// file 객체들을 formData에 담기
	for(let i = 0; i < files.length;i++){
		if(checkExtension(files[i].name, files[i].size)){
			return false;
		}
		
		formData.append("uploadFile",files[i]);
	}
	
	fetch(`/uploadAsyncAction`, {
		method : 'post',
		body : formData
	})
	.then(response => response.json())
	.then(data => {
		let hide = document.querySelectorAll("input[type='hidden']");
		if(hide != null && hide.length > 0){
			hide.forEach(el => {
				el.remove();
			})
		}
		
		if(removeList != null && removeList.length > 0 ){
			removeList.forEach(file => {
				removeFile(file);
			})
		}
		if(data != null && data.length > 0){
			showUploadedFile('', data);
		}
		
		
		hideData();
		console.log(f);
		f.action = `/board/modify?pageNum=${pageNumData}&amount=${amountData}`;
		f.submit();
	})
	.catch(err => console.log(err));
}
function removeFile(targetFile){
	fetch(`/deleteFile`,{
		method : 'post',
		body : targetFile,
		header : {
			'Content-Type' : 'text/plain'
		}
	})
	.then(response => response.text())
	.then(result => {
		
	})
	.catch(err => console.log(err));
}