<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
table {
	margin: 0 auto;
	border: 1px solid lightseagreen;
}

thead {
	background-color: lightseagreen;
	color: white;
}

tfoot {
	background-color: lightseagreen;
}

td {
	text-align: center;
	padding: 3px;
}

th {
	height: 30px;
	padding: 5px;
}

input[type=button], input[type=reset] {
	background-color: lightseagreen;
	border: 1px solid white;
	padding: 5px;
	color: white;
}

input[type=button]:hover {
	background-color: white;
	color: lightseagreen;
	font-weight: bold;
	cursor: pointer;
}
</style>
</head>
<body>
	<form method="post">
		<table>
			<thead>
				<tr>
					<th colspan="2">회원 정보 관리</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="2">
						<input type="button" value="전체보기" onclick="view_all()">&nbsp;&nbsp; 
						<input type="button" value="검색" onclick="view_one(this.form)">&nbsp;&nbsp; 
						<input type="button" value="삽입" onclick="insert(this.form)">&nbsp;&nbsp;
						<input type="button" value="삭제" onclick="remove(this.form)">&nbsp;&nbsp;
						<input type="button" value="수정" onclick="update_page(this.form)">&nbsp;&nbsp;
						<input type="reset" value="다시 작성">
					</th>
				</tr>
			</tfoot>
		</table>
	</form>
</body>

<script type="text/javascript">
	function view_all(f) {
		location.href = "view_all.jsp";
	}

	function view_one(f) {
		if (!f.id.value) {
			alert("모든 정보를 입력해주세요.");
			return;
		}

		location.href = "view_one.jsp?id=" + f.id.value;

		/* f.action = "view_one.jsp";
		f.submit(); */
	}

	function insert(f) {
		if (!f.id.value || !f.pw.value || !f.name.value || !f.age.value
				|| !f.addr.value) {
			alert("모든 정보를 입력해주세요.");
			return;
		}
		f.action = "insert.jsp";
		f.submit();
	}

	function remove(f) {
		if (!f.id.value || !f.pw.value) {
			alert("아이디와 비밀번호를 입력해주세요.");
			return;
		}
		f.action = "remove.jsp";
		f.submit();
	}

	function update_page(f) {
		if (!f.id.value || !f.pw.value) {
			alert("아이디와 비밀번호를 입력해주세요.");
			return;
		}

		f.action = "update_page.jsp";
		f.submit();
	}
</script>
</html>