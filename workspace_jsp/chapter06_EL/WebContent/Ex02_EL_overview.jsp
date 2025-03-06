<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이전 jsp 표현식</h1>
	<ul>
		<li> 7 + 2 = <%= 7 + 2 %></li>
		<li> 7 - 2 = <%= 7 - 2 %></li>
		<li> 7 * 2 = <%= 7 * 2 %></li>
		<li> 7 / 2 = <%= 7 / 2 %></li>
		<li> 7 % 2 = <%= 7 % 2 %></li>
	</ul>
	<h1>EL 표현식</h1>
	<ul>
		<li> 7 + 2 = ${7 + 2}</li>
		<li> 7 - 2 = ${7 - 2}</li>
		<li> 7 * 2 = ${7 * 2}</li>
		<li> 7 / 2 = ${7 / 2}</li>
		<li> 7 % 2 = ${7 % 2}</li>
	</ul>
	
	<h1>이전 jsp 변수 저장</h1>
	<% int num = 100; %>
	num의 값 : <%= num %>
	
	<h1>EL 변수 저장</h1>
	<% pageContext.setAttribute("num", 100); %>
	num의 값 : ${num }
	
	<h1>EL 에서 사용하는 4개의 객체 우선 순위</h1>
	<%
		pageContext.setAttribute("car", "S-class");
		request.setAttribute("car", "e-class");
		session.setAttribute("car", "c-class");
		application.setAttribute("car", "a-class");
	%>
	
	<ul>
		<li> 그냥 호출 : ${car}</li>
		<li> pageContext 호출 : ${pageScope.car}</li>
		<li> request 호출 : ${requestScope.car}</li>
		<li> session 호출 : ${sessionScope.car}</li>
		<li> application 호출 : ${applicationScope.car}</li>
	</ul>
</body>
</html>