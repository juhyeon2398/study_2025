//-----CSS 파일 추가
// 1. 파일 경로 설정
const CSS_FILE_PATH = '/resources/css/get.css';
// 2. link 태그 생성
let linkEle = document.createElement('link');
linkEle.rel = 'stylesheet';
linkEle.href = CSS_FILE_PATH;
// 3. head 태그에 link 엘리먼트 추가
document.head.appendChild(linkEle);

let pageNumData = new URLSearchParams(location.search).get("pageNum");
let amountData = new URLSearchParams(location.search).get("amount");

const f = document.forms[0];
let btns = document.querySelectorAll(".panel-body-btns .btn")
for (let el of btns) {
	el.addEventListener("click", (e) =>{
		switch (e.target.getAttribute("id")) {
		case "modifyBtn":
			modify();
			break;
		case "removeBtn":
			remove();
			break;
		case "indexBtn":
			location.href=`/board/list?pageNum=${pageNumData}&amount=${amountData}`; 
			break;
		}
	})
}

function modify(){
	if(!f.title.value){
		alert("제목을 입력해주세요.");
		return;
	}
	if(!f.content.value){
		alert("내용을 입력해주세요.");
		return;
	}
	
	f.action = `/board/modify?pageNum=${pageNumData}&amount=${amountData}`;
	f.submit();
}

// 게시글 삭제 이벤트
function remove(){
	let bnoEl = f.bno;    // bno를 가진 input태그
	f.innerHTML = '';     // form 태그 내부 비우기
	f.appendChild(bnoEl); // form 태그 내부에 bno 태그 추가
	
	f.action = "/board/remove";
	f.submit();
}