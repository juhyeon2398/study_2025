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
	<h1>향상 for문 형식의 forEach</h1>
	<% 
		String[] names = {"김", "이", "박", "최"};
		pageContext.setAttribute("Names", names);
	%>
	
	<c:forEach var="name" items="${ Names }">
		${ name }
	</c:forEach>
</body>
</html>