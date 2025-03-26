console.log("bbs.js >> load")

let pageNumData = new URLSearchParams(location.search).get("pageNum");
let amountData = new URLSearchParams(location.search).get("amount");

function moveInsertPage() {
	location.href = "BBSController?cmd=insertBBSPage";
}

function insert(f){
	if(!f.writer.value){
		alert("작성자를 입력하세요");
		f.writer.focus();
		return;
	}
	if(!f.title.value){
		alert("제목을 입력하세요");
		f.title.focus();
		return;
	}
	if(!f.pw.value){
		alert("비밀번호를 입력하세요");
		f.pw.focus();
		return;
	}

	if(!f.content.value){
		alert("내용을 입력하세요");
		f.content.focus();
		return;
	}
	f.action = "BBSController";
	f.submit();
}

// 리스트 전체 출력
function view_all(){
	
	location.href=`BBSController?cmd=allList&pageNum=${pageNumData}&amount=${amountData}`;
}

// 게시글 수정 함수
function updatePage(){
	location.href=`BBSController?cmd=updatePage&pageNum=${pageNumData}&amount=${amountData}`;
}

// 게시글 수정
function update(f,session){

	if(!f.title.value){
		alert("제목을 입력해주세요.");
		f.title.focus();
		return;
	}
	
	if(f.pw.value != session){
		alert("비밀번호를 확인해주세요.");
		f.title.focus();
		return;
	}
	
	if(!f.content.value){
		alert("내용을 입력해주세요.");
		f.title.focus();
		return;
	}
	f.action = "BBSController";
	f.submit();
	
}

// 게시글 삭제
function removeBBS(b_idx){
	// let remove = confirm("삭제하시겠습니까?");
	let clist = document.querySelector("#commBody").dataset['clist'];
	
	if(clist > 0){
		let sendData= `cmd=comment_all_delete&b_idx=${b_idx}`;
		fetch(`CommentController?${sendData}`)
			.then(response => response.json())
			.then(json => {
				location.href="BBSController?cmd=remove&b_idx="+b_idx;
			})
			.catch(err => console.log(err));
	}else{
		location.href="BBSController?cmd=remove&b_idx="+b_idx;
	} 
}

document.querySelectorAll("tbody a").forEach(aEle =>{
	aEle.addEventListener("click", function(e){
		e.preventDefault();
		
		let b_idx = this.getAttribute('href');
		let pageNum = this.getAttribute('pageNum');
		let amount = this.getAttribute('amount');
		
		let sendData = `cmd=view&b_idx=${b_idx}&pageNum=${pageNum}&amount=${amount}`;
		location.href=`BBSController?${sendData}`;
	})
})