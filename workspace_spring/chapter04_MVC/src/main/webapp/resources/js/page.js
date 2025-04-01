console.log("page.js >> load")

let aEles= document.querySelectorAll(".page-nation li a");

aEles.forEach(aEles => {
	aEles.addEventListener("click", function(e){
		e.preventDefault();
		
		let pageNum = this.getAttribute("href");
		
		let sendData = `pageNum=${pageNum}&amount=${amountData}`;
		location.href = "/board/list?"+sendData;
	})
})
