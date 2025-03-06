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
		// 쿠키 저장소의 모든 데이터 확인하기
		Cookie[] cookieBox = request.getCookies();
		
		cookieBox[1].setMaxAge(60 * 60 * 24 * 15);
		
		if(cookieBox != null && cookieBox.length > 0){
			for(int i = 0; i< cookieBox.length; i++){
				if(cookieBox[i].getName().equals("name")){					
					Cookie bisket = new Cookie("name", URLEncoder.encode("마이클조던","UTF-8"));
					bisket.setMaxAge(60 * 60 * 24 * 15);
					response.addCookie(bisket);
				}
			}
		}else{
			out.print("쿠키가 존자하지 않습니다.");
		}
	%>
</body>
</html>