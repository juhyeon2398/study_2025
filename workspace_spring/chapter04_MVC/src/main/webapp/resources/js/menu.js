document.querySelectorAll('.menu a').forEach( a => {
	a.addEventListener("click" , e => {
		e.preventDefault();
		
		let menu = e.target.getAttribute("href");
		if(menu === 'boardList'){
			location.href="/boardList";
		}
	});
})

function joinPage(){
	location.href="/member/join";
}

function loginPage(){
	location.href="/member/login";
}


// 로컬 스토리지 저장
function setStorageData(pageNum, amount){
	let pageData = {
			pageNum : pageNum,
			amount : amount
	};
	localStorage.setItem("page_data", JSON.stringify(pageData));
}

// 로컬 스토리지 출력
function getStorageData(){
	return JSON.parse(localStorage.getItem("page_data"));
}



// 
let principal;

async function getPrincipal(){
	try {
		const response = await fetch("/api/currentUser.json");
		const userPrincipal = await response.json();
		principal = userPrincipal.principal;
	} catch (e) {
		console.log("에러 : " , e);
	}
}

getPrincipal();