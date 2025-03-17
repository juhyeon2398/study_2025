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
	<c:set var="kor" value="${ param.kor }" />
	<c:set var="eng" value="${ param.eng }" />
	<c:set var="mat" value="${ param.mat }" />
	<c:set var="avg" value="${ (kor + eng + mat) / 3.0 }" />
	<c:set var="grade2" />

	<c:choose>
		<c:when test="${ avg >= 90 }">
			<c:set var="grade" value="A" />
		</c:when>
		<c:when test="${ avg >= 80 }">
			<c:set var="grade" value="B" />
		</c:when>
		<c:when test="${ avg >= 70 }">
			<c:set var="grade" value="C" />
		</c:when>
		<c:when test="${ avg >= 60 }">
			<c:set var="grade" value="D" />
		</c:when>
		<c:otherwise>
			<c:set var="grade" value="F" />
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${avg >= 60 }">
			<c:set var="pass" value="합격" />
		</c:when>
		<c:otherwise>
			<c:set var="pass" value="불합격" />
		</c:otherwise>
	</c:choose>
	
	<c:out value="국어점수 : ${kor}" /><br>
	<c:out value="영어점수 : ${eng}" /><br>
	<c:out value="수학점수 : ${mat}" /><br>
	<c:out value="평균점수 : ${avg}" /><br>
	<c:out value="학점 : ${grade}" /><br>
	<c:out value="합격여부 : ${pass}" /><br>
	
</body>
</html>