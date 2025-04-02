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
			location.href = `/board/modify?bno=${f.bno.value}&pageNum=${pageNumData}&amount=${amountData}`;
			break;
		case "indexBtn":
			location.href = `/board/list?pageNum=${pageNumData}&amount=${amountData}`; 
			break;
		}
	})
}



document.addEventListener("DOMContentLoaded",function(){
	
})

const rs = replyService;

rs.getList(656, function(data){
	for(let replys in data){
		let date = new Date(data[replys].replydate);
		console.log(
			"rno : " + data[replys].rno + "\n"
			+"bno : " + data[replys].bno + "\n"
			+"reply : " + data[replys].reply + "\n"
			+"replyer : " + data[replys].replyer + "\n"
			+"replydate : " + date.getFullYear()+ "-" + (date.getMonth() + 1)+ "-" +date.getDate()
		)
		console.log("==================================");
	}
	
});

// 댓글 관련
//rs.add({
//	reply : 'JS TEST',
//	replyer : "TESTER",
//	bno : 656
//}, function(result){
//	alert("result : " + result);
//	
//});