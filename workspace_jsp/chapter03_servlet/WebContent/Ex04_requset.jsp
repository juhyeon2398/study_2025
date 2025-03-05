<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="">
		<ul>
		  <li> 아이디 : <input type="text" name="id"> </li>
		  <li> 비밀번호 : <input type="password" name="pw"> </li>
		  <li> 이름 : <input type="text" name="name"> </li>
		  <li> 이메일 : <input type="email" name="email"> </li>
		  <li> 성별 :
			<input type="radio" name="gender" value="남">남
			<input type="radio" name="gender" value="여">여	 
		  </li>
		  <li>
		  	취미 : 
		  	<input type="checkbox" name="hobbies" value="낚시">낚시
		  	<input type="checkbox" name="hobbies" value="수영">수영
		  	<input type="checkbox" name="hobbies" value="영화">영화
		  </li>
		</ul>
		<button type="button" onclick="send(this.form);">전송</button>
	</form>

</body>
<script type="text/javascript">
	function send(f) {
		let hobbies = document.querySelectorAll('input[name=hobbies]:checked');
		
		if(f.id.value == ''){
			alert("아이디를 입력해주세요.");
			return;
		} 
		if(f.pw.value == ''){
			alert("비밀번호를 입력해주세요.");
			return;
		} 
		if(f.name.value == ''){
			alert("이름을 입력해주세요.");
			return;
		} 
		if(f.email.value == ''){
			alert("이메일을 입력해주세요.");
			return;
		}
		if(f.gender.value == ''){
			alert("성별을 선택해주세요.");
			return;
		}
		if(hobbies.length == 0){
			alert("취미를 선택해주세요.");
			return;
		}
		
		f.action = "Ex04_servlet";
		f.submit();
	}
</script>
</html>