//-----CSS 파일 추가
// 1. 파일 경로 설정
const CSS_FILE_PATH = '/resources/css/register.css';
// 2. link 태그 생성
let linkEle = document.createElement('link');
linkEle.rel = 'stylesheet';
linkEle.href = CSS_FILE_PATH;
// 3. head 태그에 link 엘리먼트 추가
document.head.appendChild(linkEle);


const f = document.forms[0];
let btns = document.querySelectorAll(".panel-body-btns .btn")
for (let el of btns) {
	el.addEventListener("click", (e) =>{
		switch (e.target.getAttribute("id")) {
		case "registerBtn":
			register();
			break;
		case "resetBtn":
			f.reset();
			break;
		case "indexBtn":
			let {pageNum, amount} = getStorageData();
			location.href = `/board/list?pageNum=${pageNum}&amount=${amount}`; 
			break;
		}
	})
}

function register(){
	if(!f.title.value){
		alert("제목을 입력해주세요.");
		return; 
	}
	if(!f.writer.value){
		alert("작성자를 입력해주세요.");
		return; 
	}
	if(!f.content.value){
		alert("내용을 입력해주세요.");
		return; 
	}
	// 첨부파일 li들 가져와서 반복문 돌리기
	// 해당 li에 포함된 속성들 꺼내서 화면에 출력
	let str = "";
	let uploadResult = document.querySelectorAll(".uploadResult ul > li");
	uploadResult.forEach((el,idx) => {
	    let path = el.getAttribute("path");
	    let uuid = el.getAttribute("uuid");
	    let fileName = el.getAttribute("filename");
	
	    str += `<input type="hidden" name="attachList[${idx}].fileName" value="${fileName}"/>`
	    str += `<input type="hidden" name="attachList[${idx}].uuid" value="${uuid}"/>`
	    str += `<input type="hidden" name="attachList[${idx}].uploadPath" value="${path}"/>`
	})
 	
 	f.insertAdjacentHTML("beforeend", str);
 	console.log(f)
 	f.action = "/board/register";
 	f.submit();
}