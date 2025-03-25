console.log("page.js >> load")

let aEles= document.querySelectorAll(".page-nation li a");

aEles.forEach(aEles => {
	aEles.addEventListener("click", function(e){
		e.preventDefault();
		
		let pageNum = this.getAttribute("href");
		console.log(pageNum)
		
		let sendData = `cmd=allList&pageNum=${pageNum}&amount=5`;
		location.href = "BBSController?"+sendData;
	})
})
