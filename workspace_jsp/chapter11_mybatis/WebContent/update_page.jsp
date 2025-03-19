<%@page import="org.joonzis.ex.MemberDao"%>
<%@page import="org.joonzis.ex.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
		
	MemberVO vo = new MemberVO();
	vo.setId(id);
	vo.setPw(pw);
	
	MemberDao dao = MemberDao.getInstance();
	MemberVO info = dao.getUpdateView(vo);	
	pageContext.setAttribute("info", info);
	pageContext.setAttribute("inputPw", pw);
%>

<c:if test="${info.pw != inputPw}">
	<script type="text/javascript">
		alert("비밀번호가 일치하지 않습니다.");
		location.href="view_all.jsp";
	</script>
</c:if>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="index.jsp" />
	
	<br>
	<hr>
	<br>
	
	<h1></h1>
	<form method="post">
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
							<td><input type="hidden" name="idx" value="${ info.idx }">${ info.idx }</td>
							<td>${ info.id }</td>
							<td><input type="text" name="pw" value="${ info.pw }"></td>
							<td><input type="text" name="name" value="${ info.name }"></td>
							<td><input type="number" name="age" value="${ info.age }"></td>
							<td><input type="text" name="addr" value="${ info.addr }"></td>
							<td>${ info.regdate }</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="7">
						<input type="button" value="수정" onclick="update(this.form)">&nbsp;&nbsp;
						<input type="reset" value="다시 작성">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
<script type="text/javascript">
	function update(f) {
		if(!f.pw.value || !f.name.value || !f.age.value || !f.addr.value){
			alert("데이터를 모두 입력해주세요.");
			return;
		} 
		f.action = "update.jsp";
		f.submit();
	}
</script>

</html>







