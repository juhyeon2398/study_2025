<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/security/tags" prefix = "sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>doAdmin...</h1>
	<!-- 
		principal.member
		member -> CustomUser.java의 내용
	 -->
	<p>principal : <sec:authentication property="principal"/> </p>
	<p>MemberVO : <sec:authentication property="principal.member"/> </p>
	<p>사용자 이름 : <sec:authentication property="principal.member.userName"/> </p>
	<p>사용자 ID&nbsp;&ensp;: <sec:authentication property="principal.member.userId"/> </p>
	<p>사용자 ID2 : <sec:authentication property="principal.username"/> </p>
	<p>사용자 권한 리스트: <sec:authentication property="principal.member.authList"/> </p>
	<a href="/customLogout">LogOut</a>
</body>
</html>