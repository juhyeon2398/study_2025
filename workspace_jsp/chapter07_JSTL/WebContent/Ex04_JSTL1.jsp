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
	<!-- 성적 입력 화면 form -->
	<!-- 국어 : kor, 영어 : eng, 수학 : mat, action : Ex04_JSTL2.jsp -->
	<!-- Ex04_JSTL2.jsp 에서 할일 
		1. 변수 생성 - avg, grade, pass 
		90점 이상 A,
		2. 합/불합 출력
		* 평균 60점 이상이면 합격
		3. 데이터 출력
		* 국, 영, 수, 평균, 학점, 합격여부
	 -->
	<form action="Ex04_JSTL2.jsp">
		국어 점수 : <input type="text" name="kor"> <br>
		영어 점수 : <input type="text" name="eng"> <br>
		수학 점수 : <input type="text" name="mat"> <br>
		<input type="submit" value="전송">
	</form>
</body>
</html>