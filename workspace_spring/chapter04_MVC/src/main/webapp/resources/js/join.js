//-----CSS 파일 추가
// 1. 파일 경로 설정
const CSS_FILE_PATH = '/resources/css/join.css';
// 2. link 태그 생성
let linkEle = document.createElement('link');
linkEle.rel = 'stylesheet';
linkEle.href = CSS_FILE_PATH;
// 3. head 태그에 link 엘리먼트 추가
document.head.appendChild(linkEle);

let btns = document.querySelectorAll(".btn");
for (let el of btns) {
	el.addEventListener("click" , (e)=>{
		console.log(e.target.getAttribute("id"))
		switch (e.target.getAttribute("id")) {
		case "joinBtn":
			join();
			break;
		case "loginBtn":
			login();
			break;
	
		}
	})
}

const f = document.forms[0];
function join(){
	if(!f.userId.value || !f.userPw.value || !f.userPwChk.value || !f.userName.value){
		alert("정보를 정확히 기입해주세요.")
		return;
	}
	
	if(!f.userPw.value !== !f.userPwChk.value){
		alert("비밀번호가 같지 않습니다.")
		return;
	}
	
	f.action = "/member/join";
	f.submit();
}

function login(){
	if(!f.userId.value || !f.userPw.value){
		alert("정보를 정확히 기입해주세요.")
		return;
	}
	
	f.action = "/member/login";
	f.submit();
}