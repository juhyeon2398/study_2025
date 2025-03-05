<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>페이지 이동 중간 페이지</h1>
	<div>이름 : <%= name %></div>
	<div>나이 : <%= age %></div>
	<br> <hr> <br>
	<a href="Ex05_03_page_move.jsp">파라미터 X</a>
	<a href="Ex05_03_page_move.jsp?name=<%=name%>&age=<%= age %>">파라미터 o</a>
	<br> <hr> <br>
	
	<!-- 2. loaction 객체로 이동하기 -->
	<button onclick="location.href='Ex05_03_page_move.jsp'">파라미터 X</button>
	<button onclick="location.href='Ex05_03_page_move.jsp?name=<%= name %>&age=<%=age%>'">파라미터 X</button>
	<br> <hr> <br>

	<!-- 3. forward로 이동하기 (주소변경 X)-->
	<%
		// request.getRequestDispatcher("Ex05_03_page_move.jsp").forward(request, response);
	%>
	<!-- 4. redirect로 이동 (주소 변경 O)ㅋ--> 
	<% response.sendRedirect("Ex05_03_page_move.jsp"); %>
</body>
</html>