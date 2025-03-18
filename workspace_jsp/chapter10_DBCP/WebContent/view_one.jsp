<%@page import="org.joonzis.ex.MemberDao"%>
<%@page import="org.joonzis.ex.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String id = request.getParameter("id");
	MemberDao dao = MemberDao.getInstance();
	MemberVO info = dao.getUserInfoById(id);	
	pageContext.setAttribute("info", info);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="index.jsp"/>
	
	<br><hr><br>

	<table>
		<thead>
			<tr>
				<th>회원번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>주소</th>
				<th>가입일</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty info}">
					<tr><td colspan="7">member 데이터가 없습니다.</td></tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td>${ info.idx }</td>
						<td>${ info.id }</td>
						<td>${ info.pw }</td>
						<td>${ info.name }</td>
						<td>${ info.age }</td>
						<td>${ info.addr }</td>
						<td>${ info.regdate }</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>