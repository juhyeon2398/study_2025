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
	
	uploadAsyncAction(f, "register");
}