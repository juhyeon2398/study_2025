<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 쿠키 삭제는 기존 쿠키의 유효기간을 0으로 바꾼다.
		// 1. 이름이 name인 쿠키 삭제
		
		Cookie[] cookieBox = request.getCookies();
		
		if(cookieBox != null && cookieBox.length > 0){
			for(int i = 0; i< cookieBox.length; i++){
				out.print(cookieBox[i].getName().equals("name"));
				if(cookieBox[i].getName().equals("name")){
					cookieBox[i].setMaxAge(0);
					
					
					 Cookie bisket = new Cookie("name", "");
					 bisket.setMaxAge(0);
					 response.addCookie(bisket);
				}
			}
		}else{
			out.print("쿠키가 존자하지 않습니다.");
		}
	%>
</body>
</html>