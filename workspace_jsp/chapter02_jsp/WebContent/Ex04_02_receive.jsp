<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String tel = request.getParameter("tel");
	String gender = request.getParameter("gender");
	String[] hobbies = request.getParameterValues("hobbies");
	String addr = request.getParameter("addr");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>이름 : <%= name %></li>
		<li>나이 : <%= age %></li>
		<li>전화번호 : <%= tel %></li>
		<li>성별 : <%= gender %>자</li>
		<li>취미 : <% for(String stu : hobbies) {%> <%= stu %> <% } %></li>
		<li>주소 : <%= addr %></li>
	</ul> 
</body>

</html>