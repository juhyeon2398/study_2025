<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<table>
			<tbody>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="age"></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="text" name="phone"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr"></td>
				</tr>
				<tr>
					<td>자기소개</td>
					<td><textarea name="self"
							style="resize: none; width: 200px; height: 100px"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="전송"
						onclick="send(this.form)"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>

<script type="text/javascript">
	function send(f) {
		f.action = "/chapter14_MVC2/Controller"
		f.submit();
	}
</script>

</html>