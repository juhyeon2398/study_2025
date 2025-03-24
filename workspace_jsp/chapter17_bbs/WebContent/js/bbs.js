console.log("bbs.js >> load")

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
	// history.back();
	location.href="BBSController?cmd=allList";
}

// 게시글 수정 함수
function updatePage(){
	location.href="BBSController?cmd=updatePage";
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
	let remove = confirm("삭제하시겠습니까?");
	if(remove){
		location.href="BBSController?cmd=remove&b_idx="+b_idx;
	}
}

