function insert_comment(f){
	if(!f.writer.value){
		alert('작성자를 입력하세요.');
		return;
	}
	if(!f.pw.value){
		alert('비밀번호를 입력하세요.');
		return;
	}
	if(!f.content.value){
		alert('내용을 입력하세요.');
		return;
	}
	
	let formData = new FormData(f);
	
	// 직렬화
	let serializedData = 
		new URLSearchParams(formData).toString();
	
	fetch(`CommentController?${serializedData}`)
		.then(response => response.json())
		.then(json => {
			console.log(json.result)
			f.reset(); // 삽입 성공 후 input 데이터 비우기
			
			showCommList();
		})
		.catch(err => console.log(err));
}

showCommList(); // 페이지가 로드 되면서 리스트 함수 실행
// 댓글 리스트 함수
function showCommList(){
	// url 에서 특정 파라미터 가져오는 코드
	
	let b_idx = new URLSearchParams(location.search).get("b_idx");
	let tbody = document.querySelector(".viewComment tbody");
	let sendData= `cmd=commList&b_idx=${b_idx}`;
	let msg = "";
	fetch(`CommentController?${sendData}`)
		.then(response => response.json())
		.then(json => {
			let cList = JSON.parse(json.cList);
			tbody.setAttribute("data-clist",cList.length);
			
			cList.forEach(clist => {
				msg += `<tr>`;
				msg	+= `<td style="text-align:center">${clist['c_idx']}</td>`;
				msg	+= `<td>${clist['writer']}</td>`;
				msg	+= `<td>${clist['content']}</td>`;
				msg	+= `<td style="text-align:center">${myTime(clist['reg_date'])}</td>`;
				msg	+= `<td style="text-align:center"><input type='button' onclick="comment_del(${clist['c_idx']})" class="comment_del" value="삭제"></td>`;
				msg	+= `</tr>`;
				tbody.innerHTML = msg;
			});
			if(!msg){
				msg += `<tr>`
				msg += `<td style="text-align:center" colspan="5">댓글이 없습니다.</td>`
				msg += `</tr>`
				tbody.innerHTML = msg;
			}
			
		})
		.catch(err => console.log(err));
}

function myTime(unixTimeStamp){
	// 1.밀리초로 넘어오면 / 1000을 해준다.
	// 2.초로 넘어오면 그냥 사용
	let myDate = new Date(unixTimeStamp);
	
	let date = myDate.getFullYear() + '-' + String(myDate.getMonth() + 1) + '-' + myDate.getDate();
	return date;
}


function comment_del(c_idx){
	let sendData= `cmd=comment_Delete&c_idx=${c_idx}`;
	fetch(`CommentController?${sendData}`)
		.then(response => response.json())
		.then(json => {
			showCommList();
		})
		.catch(err => console.log(err));
}




