let uploadDiv = document.querySelector(".uploadDiv");
let cloneObj = uploadDiv.firstElementChild.cloneNode(true);

const regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
const MAX_SIZE = 5242880; //5MB
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

let str = "";
let hideStr = "";
function showUploadedFile(uploadResultArr, f){
	if(!uploadResultArr || uploadResultArr.length == 0){
		return;
	}

	uploadResultArr.forEach(file =>{
		let fileCallPath = 
			encodeURIComponent(
					file.uploadPath + "/" + file.uuid + "_" + file.fileName)
		str += `<li path="${file.uploadPath}" uuid="${file.uuid}" filename="${file.fileName}">`;
		//str += 		`<a href="/download?fileName=${fileCallPath}">${file.fileName}</a>`;
		str += 		`<a>${file.fileName}</a>`;
		str += 		`<span data-file='${fileCallPath}'> X </span>`;
		str += `</li>`;
	});
	uploadResult.innerHTML = str;
	
	let uploadList = document.querySelectorAll(".uploadResult ul li");
	uploadList.forEach((el,idx) => {
		if(el.getAttribute('uuid') == null){
			console.log("remove")
			el.remove();
		};
		
		let newIdx = uploadList.length;
		let path = el.getAttribute("path");
		let uuid = el.getAttribute("uuid");
		let fileName = el.getAttribute("filename");
		
		hideStr += `<input type="hidden" name="attachList[${idx}].fileName" value="${fileName}"/>`
		hideStr += `<input type="hidden" name="attachList[${idx}].uuid" value="${uuid}"/>`
		hideStr += `<input type="hidden" name="attachList[${idx}].uploadPath" value="${path}"/>`
	})
	f.insertAdjacentHTML("beforeend", hideStr);
}

uploadResult.addEventListener("click" ,function(e){
	if(e.target.tagName == "SPAN"){
		let targetFile = e.target.getAttribute("data-file");
		
		fetch(`/deleteFile`,{
			method : 'post',
			body : targetFile,
			header : {
				'Content-Type' : 'text/plain'
			}
		})
		.then(response => response.text())
		.then(result => {
			console.log(result);
			
			let targetLi = e.target.closest('li');
			targetLi.remove();
		})
		.catch(err => console.log(err));
	}
})
 



const fileInput = document.querySelector("input[type='file']");

fileInput.addEventListener("change" ,() => {
	const files = fileInput.files;
	for(let i = 0; i < files.length;i++){
		let newStr = "";
		
		newStr += `<li>`;
		newStr += 		`<a>${files[i].name}</a>`;
		newStr += 		`<span data-file='{$fileCallPath}'> X </span>`;
		newStr += `</li>`;
		
		uploadResult.innerHTML += newStr;
	}
})

function uploadAsyncAction(f , page){
	const formData = new FormData();
	
	const files = fileInput.files;
	
	// file 객체들을 formData에 담기
	for(let i = 0; i < files.length;i++){
		console.log("files : " + files[i].name);
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
		showUploadedFile(data, f);
		if(page === "modify"){
			f.action = `/board/modify?pageNum=${pageNumData}&amount=${amountData}`;
		}else{
			f.action = `/board/register`;	
		}
		
		f.submit();
	})
	.catch(err => console.log(err));
	
}
