<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		2번 파일에서 두 값의 합계 출력
		1. 스크립트릿을 이용하여 파라미터를 전달 받아 합계를 속성에 저장하여 출력
		2. EL표기법으로 바로 계산하여 출력
	 -->
	 ${
	 	request.getParameter("num1")  
	 }
	 <br>
	 
	 두 값의 합은 : ${ param.num1 + param.num2}
</body>
</html>