<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	/* 1. 쿠키 만들기 ( 서버로 쿠키 만들기 ) */
	Cookie cookie = new Cookie("id", "admin");
	
	// 유효기간 설정 (1일)
	cookie.setMaxAge(60 * 60 * 24);
	
	// 값에 공백, 콤마, 괄호 등을 저장하라면 인코딩 필요
	Cookie bisket = new Cookie("name", URLEncoder.encode("김씨","UTF-8"));
	
	// bisket의 유효 기간을 20분으로 설정
	bisket.setMaxAge(60 * 20);
	
	// 쿠키저장
	response.addCookie(cookie);
	response.addCookie(bisket);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 
		쿠키 1 이름 : <%= cookie.getName() %> <br>
		쿠키 1 값 : <%= cookie.getValue() %><br>
		쿠키 2 이름 : <%= bisket.getName() %><br>
		쿠키 2 값 : <%= URLDecoder.decode(bisket.getValue(), "utf-8") %>
	</h1>
</body>
</html>