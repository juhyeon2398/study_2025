<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<table>
			<tbody> 
				 <tr>
				 	<th>이름</th>
				 	<td> <input type="text" name="name"> </td>
				 </tr>
				 <tr>
				 	<th>나이</th>
				 	<td> <input type="number" name="age"> </td>
				 </tr>
				 <tr>
				 	<th>전화번호</th>
				 	<td><input type="tel" name="tel"></td>
				 </tr>
				 <tr>
				 	<th>성별</th>
				 	<td>
				 		<input type="radio" name="gender" value="남">남
				 		<input type="radio" name="gender" value="여">여
			 		</td>
				 </tr>
				 <tr>
				 	<th>취미</th>
				 	<td>
				 		<input type="checkbox" name="hobbies" value="음악">음악
				 		<input type="checkbox" name="hobbies" value="노래">노래
				 		<input type="checkbox" name="hobbies" value="게임">게임
			 		</td>
				 </tr>
				 <tr>
				 	<th>주소</th>
				 	<td> 	
				 		<select name="addr">
				 			<option value="서울">서울</option>
				 			<option value="인천">인천</option>
				 			<option value="경기">경기</option>
				 			<option value="강원">강원</option>
				 		</select> 
			 		</td>
				 </tr>
				 <tr>
				 	<td colspan="2"><input type="hidden" name="nickname"></td>
				 </tr>
			</tbody>
		</table>
		<button type="button" onclick="send(this.form);">전송</button>
	</form>
</body>

<script>
	function send(f){
		f.action = "Ex04_02_receive.jsp";
		f.submit();
	}
</script>

</html>