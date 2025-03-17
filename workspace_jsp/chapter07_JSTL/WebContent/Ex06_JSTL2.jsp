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
	<!-- 1. 최소, 최대값 화면 출력 -->
	<c:set var="num1" value="${param.num1}" />
	<c:set var="num2" value="${param.num2}" />

	<p>입력된 최소 값 : ${num1}</p>
	<p>입력된 최대 값 : ${num2}</p>
	<hr>
	<c:if test="${param.num1+0 > param.num2+0}">
		<c:set var="num1" value="${param.num2}" />
		<c:set var="num2" value="${param.num1}" />
	</c:if>
	
	<p>최소 값 : ${num1}</p>
	<p>최대 값 : ${num2}</p>
	<hr>
	<!-- 2. 최소 값 부터 최대 값 까지 1씩 증가하는 값 출력 -->
	<c:forEach var="i" begin="${num1}" end="${num2}" step="1">${ i }&ensp;</c:forEach>
	<hr>
	<!-- 3. 향상 forEach를 이용하여 음식 종류 출력 -->
	<c:forEach var="food" items="${paramValues.foods}">
		${ food } /
	</c:forEach>
</body>
</html>