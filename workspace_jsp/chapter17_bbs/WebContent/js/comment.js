console.log("comment.js >> load")

function insert_comment(f){
	if(!f.writer.value){
		alert("작성자를 입력하세요.");
		return;
	}
	if(!f.pw.value){
		alert("비밀번호룰 입력하세요.");
		return;
	}
	if(!f.content.value){
		alert("내용 입력하세요.");
		return;
	}

	let formData = new FormData(f);
	// 직렬화 
	let serializedData = new URLSearchParams(formData).toString();

	fetch(`CommentController?${serializedData}`)
	.then(response => response.json() )
	.then(json => {
		console.log(" insert_comment  :  json", json)
	})
	.catchj(err => console.log(err));
}