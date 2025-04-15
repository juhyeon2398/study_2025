<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />

	<form method="post">
		<table>
			<colgroup>
				<col width="150px">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>아이디</th>
					<th><input type="text" name="userId" placeholder="아이디를 입력해주세요."></th>
				</tr>
				<tr>
					<th>비밀번호</th>
					<th><input type="password" name="userPw" placeholder="비밀번호를 입력해주세요."></th>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<th><input type="password" name="userPwChk" placeholder="비밀번호 확인"></th>
				</tr>
				<tr>
					<th>이름</th>
					<th><input type="text" name="userName" placeholder="이름을 입력해주세요."></th>
				</tr>
			</tbody>
		</table>
		<div class="panel-body-btns">
			<button type="button" class="btn btn-sec" id="joinBtn">회원가입</button>
			<button type="button" class="btn btn-fir" id="resetBtn">다시 작성</button>
		</div>
	</form>
	<jsp:include page="../layout/footer.jsp" />
	<script type="text/javascript" src="/resources/js/join.js"></script>
</body>
</html>