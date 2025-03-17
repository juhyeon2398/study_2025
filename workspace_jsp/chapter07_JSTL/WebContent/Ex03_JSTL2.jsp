<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	첫 번째 값 : ${ param.num1 } <br>
	두 번째 값 : ${ param.num2 }
	
	<hr>
	
	<h1> EL을 이용하여 큰 수 출력하기 ( 삼항 연산자 )</h1>
	<c:set var="num1" value="${ Integer.parseInt(param.num1) }" />
	<c:set var="num2" value="${ Integer.parseInt(param.num2) }" />
	
	<c:if test="${num1 > num2}">${ num1 }</c:if>
	<c:if test="${num1 < num2}">${ num2 }</c:if>
	<c:choose>
		<c:when test="${num1 > num2}">${ num1 }</c:when>
		<c:otherwise>${ num2 }</c:otherwise>
	</c:choose>
	
</body>
</html>