//-----CSS 파일 추가
// 1. 파일 경로 설정
const CSS_FILE_PATH = [
	'/resources/css/boardList.css',
	'/resources/css/page.css'
];
// 2. link 태그 생성
for (let hrefs of CSS_FILE_PATH) {
	let linkEle = document.createElement('link');
	linkEle.rel = 'stylesheet';
	linkEle.href = hrefs;
// 3. head 태그에 link 엘리먼트 추가
	document.head.appendChild(linkEle);
}

document.querySelector("#registerBtn").addEventListener("click", (e) => {
	location.href="/board/register";
})

let pageNumData = document.querySelector(".page-nation").dataset['pagenum'];
let amountData = document.querySelector(".page-nation").dataset['amount'];

// 글 제목 클릭 이벤트
onload = function(){
	document.querySelectorAll(".panel-body a").forEach(a => {
		a.addEventListener("click", (e) => {
			e.preventDefault();
			let bno = a.getAttribute("href");
			
			location.href=`/board/0`;
		})
	})
}

// URL에서 파라미터 값 찾아 스토리지 저장
let pageNum = new URLSearchParams(location.search).get("pageNum");
let amount = new URLSearchParams(location.search).get("amount");
if(!pageNum || !amount){
	pageNum = 1;
	amount = 5;
}
setStorageData(pageNum, amount);

