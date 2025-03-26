let sendData;

/* ========== Form 관련 요소 ==========*/ 
const f = document.forms[0];
const LOGIN_FAIL_MSG = '아이디 또는 비밀번호가 일치하지 않습니다.';

/* ========== 함수 ==========*/


let btn = document.querySelectorAll("button"); 
btn.forEach(el => {
	el.addEventListener("click", function(){
		let target = this.getAttribute("id")
		if(target === 'loginBtn'){
			login();
		}else{
			location.href="MemberController?mainPage";
		}
	})
})

function login(){
	if(f.mId.value === ''){
		alert("아이디를 입력해주세요.");
		return;
	}
	if(f.mPw.value === ''){
		alert("비밀번호를 입력해주세요.");
		return;
	}
	
    // FormData 객체 새엉
    let formData = new FormData(f);
    // formdata to json
    let jsonData = JSON.stringify(Object.fromEntries(formData.entries()))
	// post 방식 
	fetch(`MemberAsyncController`, {
		method : 'post',
		body : jsonData,
		header : {
			'Content-type' : 'application/json; charset=utf-8'
		}
		
	})
        .then(response => response.json())
        .then(data => {
			if(data.result === "success"){
				alert("로그인되었습니다.")
				location.href="MemberController?mainPage";
			}else{
				alert(LOGIN_FAIL_MSG);
				f.reset();
			}
        })
        .catch(err => console.log(err));

}