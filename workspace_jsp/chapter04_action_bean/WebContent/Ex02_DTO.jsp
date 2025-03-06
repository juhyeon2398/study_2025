<%@page import="org.joonzis.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 클래스 파일(bean)을 이용하여 데이터 저장,사용
	String[] hobbies = {"노래","음악"};
	String[] likeFoods = {"김치","밥"};
	String[] dislikeFoods = {"달걀","국"};
	MemberDTO m = new MemberDTO();
	m.setId("admin");
	m.setPw("1234");
	m.setName("김씨");
	m.setAge(20);
	m.setAddr("서울");
	m.setGender("남");
	m.setHobbies(hobbies);
	m.setLikeFoods(likeFoods);
	m.setDislikeFoods(dislikeFoods);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>아이디 : <%= m.getId() %></li>
		<li>비밀번호 : <%= m.getPw() %></li>
		<li>이름 : <%= m.getName() %></li>
		<li>나이 : <%= m.getAge() %></li>
		<li>주소 : <%= m.getAddr() %></li>
		<li>성별 : <%= m.getGender() %></li>
		<li>취미 : <% for(String hobby : m.getHobbies()){
			out.print(hobby + " / ");	
		} %></li>
		<li>좋아하는 음식 : <% for(String likeF : m.getLikeFoods()){
			out.print(likeF + " / ");	
		} %></li>
		<li>싫어하는 음식 : <% for(String dislikeF : m.getDislikeFoods()){
			out.print(dislikeF + " / ");	
		} %></li>
		
	</ul>
</body>
</html>