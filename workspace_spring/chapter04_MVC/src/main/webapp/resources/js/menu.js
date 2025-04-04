document.querySelectorAll('.menu a').forEach( a => {
	a.addEventListener("click" , e => {
		e.preventDefault();
		
		let menu = e.target.getAttribute("href");
		if(menu === 'boardList'){
			location.href="/board/list";
		}
	});
})


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