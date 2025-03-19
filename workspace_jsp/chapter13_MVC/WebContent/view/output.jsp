<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="input.jsp" />
	
	<h1>현재 시간 (표현식) : <%= request.getAttribute("now") != null  ? request.getAttribute("now") : "00시 00분 00초" %></h1>
	<h1>현재 시간 (EL) : ${now != null ? now : "00시 00분 00초"}</h1>
	<hr>
	<h1>현재 날짜 (표현식) : <%= request.getAttribute("today") != null  ? request.getAttribute("today") : "00년 00월 00일" %></h1>
	<h1>현재 날짜 (EL) : ${today != null ? today : "00년 00월 00일"}</h1>
</body>
</html>