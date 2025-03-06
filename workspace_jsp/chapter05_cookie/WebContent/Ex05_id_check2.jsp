<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Cookie cookie = null;
	String id = request.getParameter("id");
	String save_id = request.getParameter("save_id");
	
	if(save_id == null){
		// 기억 해제
		cookie = new Cookie("save_id", id);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}else{
		// 기억 설정
		cookie = new Cookie("save_id", id);
		cookie.setMaxAge(60 * 60 * 24);
		response.addCookie(cookie);
	}
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="Ex05_id_check1.jsp" >로그인 화면 이동</a>
</body>
</html>