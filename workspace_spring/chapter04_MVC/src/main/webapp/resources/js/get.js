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
let btns = document.querySelectorAll(".btn")
for (let el of btns) {
	el.addEventListener("click", (e) =>{
		console.log(e.target.getAttribute("id"))
		switch (e.target.getAttribute("id")) {
		case "modifyBtn":
			location.href = `/board/modify?bno=${f.bno.value}&pageNum=${pageNumData}&amount=${amountData}`;
			break;
		case "indexBtn":
			location.href = `/board/list?pageNum=${pageNumData}&amount=${amountData}`; 
			break;
		case "addReplyBtn": // 댓글 등록
			 registerReply();
			break;
		case "modifyReplyBtn": // 댓글 수정
			modifyReply();
			break;
		case "removeReplyBtn": // 댓글 삭제
			removeReply();
			break;
		case "replyBtn": // 댓글 달기
			registerModal();
			break;
		case "closeModalBtn": // 댓글 취소
			closeModal();
			break;
		}
	})
}

// ==========================================================
const rs = replyService;

// 댓글 목록 가져오기
showList();
function showList(){
	const bno = f.bno.value;
	const replyUL = document.querySelector(".chat");
	let msg = "";
	rs.getList(bno, jsonArray => {
		console.log(jsonArray);
		if(jsonArray.length != 0){
			
		jsonArray.forEach(json => {
			let date = new Date(json.updatedate);
			let replydate = date.getFullYear()+ "-" + String(date.getMonth() + 1).padStart(2, '0')+ "-" + String(date.getDate()).padStart(2, '0');
			
			msg += `<li data-rno="${json.rno}" onclick="modifyModalPage(this)">`
			msg += 		`<div>`
			msg += 			`<div class="chat-header">`
			msg += 				`<strong>${json.replyer}</strong>`
			msg += 				`<small class="pull-right">${replydate}</small>`
			msg += 			`</div>`
			msg += 			`<p>${json.reply}</p>`
			msg += 		`</div>`
			msg += `</li>`
		});
		}else{
			msg += `<li style="border:none;margin-bottom:0;text-align:center">`
			msg += 		`댓글이 없습니다.`	
			msg += `</li>`
		}
		replyUL.innerHTML = msg;
	});
}


// ================== 모달관련 스크립트 ==================
const modal = document.querySelector("#modal");
const replyList = document.querySelector(".chat");
const inputReply = document.querySelector("input[name='reply']");
const inputReplyer = document.querySelector("input[name='replyer']");
const inputReplydate = document.querySelector("input[name='replydate']");
const addReplyBtn = document.querySelector("#addReplyBtn");
const modifyReplyBtn = document.querySelector("#modifyReplyBtn");
const removeReplyBtn = document.querySelector("#removeReplyBtn");

function openModal(){
	modal.style.display = "block";
	
}
function closeModal(){
	modal.style.display = "none";
}

function registerModal(){
	// 보여질 목록 수정
	registerModalStyle();
	// input 내용 초기화
	inputReply.value = '';
	inputReplyer.value = '';
	
	openModal();
}

// 댓글 등록 버튼 클릭시 스타일 변경 함수
function registerModalStyle(){
	inputReplydate.closest("div").classList.add('hide');
	modifyReplyBtn.classList.add("hide");
	removeReplyBtn.classList.add('hide');
	inputReplyer.removeAttribute('readonly');
	addReplyBtn.classList.remove('hide');
}

// 댓글 목록 클릭시 스타일 변경 함수
function modifyReplyModalStyle(){
	inputReplydate.closest("div").classList.remove('hide');
	modifyReplyBtn.classList.remove("hide");
	removeReplyBtn.classList.remove('hide');
	
	addReplyBtn.classList.add('hide');
	inputReplydate.setAttribute('readonly',true);
	inputReplyer.setAttribute('readonly',true);
}

// 댓글 등록
function registerReply(){
	if(!inputReply.value || !inputReplyer.value){
		alert("든 내용을 입력하세요.");
		return;
	}
	
	const bno = f.bno.value;
	rs.add({
		reply : inputReply.value,
		replyer : inputReplyer.value,
		bno : f.bno.value
	}, function(result){
		console.log("result : " + result);
		closeModal();
		showList();
	});
}

// 댓글 수정 modal
function modifyModalPage(li){
	let rno = li.dataset['rno'];
	document.querySelector(".modal-content").setAttribute('data-rno', rno);
	
	rs.get(rno, function(data){
		let date = new Date(data.updatedate);
		let replydate = date.getFullYear()+ "-" + String(date.getMonth() + 1).padStart(2, '0')+ "-" + String(date.getDate()).padStart(2, '0');
		inputReply.value = data.reply;
		inputReplyer.value = data.replyer;
		inputReplydate.value = replydate;
		modifyReplyModalStyle();
		openModal();
	})
}

// 댓글 수정
function modifyReply(){
	rs.update({
		reply : inputReply.value,
		replyer : inputReplyer.value,
		rno : document.querySelector(".modal-content").dataset['rno']
	},function(result){
		console.log(result);
		closeModal();
		showList();
	})
}

function removeReply(){
	let rno = document.querySelector(".modal-content").dataset['rno'];
	rs.remove(rno, function(data){ 
		closeModal();
		showList();
	})
}

// =============== 첨부파일 스크립트 ===============
let str = "";
let uploadResult = document.querySelector(".uploadResult ul");

fetch(`/board/getAttachList/`+f.bno.value)
.then(response => response.json())
.then(result =>{
	showUploadFiles(result);
})
.catch(err => console.log(err))

function showUploadFiles(result){
	if(!result || result.length == 0){
		return;
	}
	result.forEach(file => {
		let fileCallPath = 
			encodeURIComponent(
					file.uploadPath + "/" + file.uuid + "_" + file.fileName)
		str += `<li>`;
		str += 		`<a href="/download?fileName=${fileCallPath}">${file.fileName}</a>`;
		str += `</li>`;
	})
	uploadResult.innerHTML = str;
}
