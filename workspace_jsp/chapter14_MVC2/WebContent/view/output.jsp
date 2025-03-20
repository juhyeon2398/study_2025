<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>1. request 확인</h1>
	<ul>
		<li> ${ name }</li>
		<li> ${ age }</li>
		<li> ${ phone }</li>
		<li> ${ addr }</li>
		<li> ${ self }</li>
	</ul>
	<h1>2. session 확인</h1>
	<ul>
		<li> ${ sessionScope.name }</li>
		<li> ${ sessionScope.age }</li>
		<li> ${ sessionScope.phone }</li>
		<li> ${ sessionScope.addr }</li>
		<li> ${ sessionScope.self }</li>
	</ul>
	<h1>1. vo 확인</h1>
	<ul>
		<!-- 필드 값이 아닌 getter를 호출하는 것 -->
		<li> ${ vo.name }</li>
		<li> ${ vo.age }</li>
		<li> ${ vo.phone }</li>
		<li> ${ vo.addr }</li>
		<li> ${ vo.self }</li>
	</ul>
	<h1>1. map 확인</h1>
	<ul>
		<li> ${ map.name }</li>
		<li> ${ map.age }</li>
		<li> ${ map.phone }</li>
		<li> ${ map.addr }</li>
		<li> ${ map.self }</li>
	</ul>
</body>
</html>