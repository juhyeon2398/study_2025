<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${member.mId != null}">
		<h1>로그인 : ${member.mId}</h1>	
	</c:if>
	<c:choose>
		<c:when test="${member.mId == null}">
			<button id="loginBtn">로그인</button>
			<button id="joinBtn">회원가입</button>
		</c:when>
		<c:otherwise>
			<button id="myPageBtn">마이페이지</button>
			<button id="logOutBtn">로그아웃</button>
		</c:otherwise>
	</c:choose>
	
</body>

<script type="text/javascript" src="./js/main.js"></script>
</html>