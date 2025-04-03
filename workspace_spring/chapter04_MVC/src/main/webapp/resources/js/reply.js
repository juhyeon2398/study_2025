console.log("reply module...");

const replyService = (function(){

	// 댓글 삽입 함수
	function add(vo, callback){
		fetch('/reply/new', {
			method : 'post',
			body : JSON.stringify(vo),
			headers : {
				"Content-type" : "application/json; charset=utf-8"
			}
		})
		.then(response => response.text())
		.then(data => {
			callback(data);
		})
		.catch(err => console.log(err))
	}
	
	// 댓글 목록 함수
	function getList(bno, callback){
		fetch(`/reply/pages/${bno}.json`)
		.then(response => response.json())
		.then(data => {
			callback(data);
		})
		.catch(err => console.log(err))
	}
	
	// 댓글 삭제 함수
	function remove(rno, callback){
		fetch(`/reply/${rno}`, {
			method : 'delete'
//			body : JSON.stringify(rno),
//			headers : {
//				"Content-type" : "application/json; charset=utf-8"
//			}
		})
		.then(response => response.text())
		.then(data => {
			callback(data);
		})
		.catch(err => console.log(err))
	}
	
	// 댓글 수정 함수
	function update(vo, callback){
		fetch(`/reply/${vo.rno}`, {
			method : 'put',
			body : JSON.stringify(vo),
			headers : {
				"Content-type" : "application/json; charset=utf-8"
			}
		})
		.then(response => response.text())
		.then(data => {
			callback(data);
		})
		.catch(err => console.log(err))
	}
	
	// 댓글 조회
	function get(rno, callback){
		fetch(`/reply/${rno}.json`)
		.then(response => response.json())
		.then(data => {
			callback(data);
		})
		.catch(err => console.log(err))
	}
	return {
		add : add,
		getList : getList,
		remove : remove,
		update : update,
		get : get
	}
})();

