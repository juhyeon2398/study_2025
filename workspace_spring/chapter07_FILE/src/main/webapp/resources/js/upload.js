
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

const uploadBtn = document.querySelector("#uploadBtn");

uploadBtn.addEventListener("click" ,() => {
	const formData = new FormData();
	
	const inputFile = document.querySelector("input[type='file']");
	const files = inputFile.files;
	
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
		console.log(data);
	})
	.catch(err => console.log(err));
})