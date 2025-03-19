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
	int result = dao.remove(vo);
	pageContext.setAttribute("result", result);
	
%>
<c:choose>
	<c:when test="${result > 0}">
		<script type="text/javascript">
			alert("삭제에 성공하였습니다.");
			location.href="view_all.jsp";
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("삭제에 실패해였습니다");
			location.href="view_all.jsp";
		</script>
	</c:otherwise>
</c:choose>