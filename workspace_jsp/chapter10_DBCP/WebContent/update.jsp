<%@page import="org.joonzis.ex.MemberDao"%>
<%@page import="org.joonzis.ex.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
	String idx = request.getParameter("idx");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String addr = request.getParameter("addr");
		
	MemberVO vo = new MemberVO();
	vo.setIdx(Integer.parseInt(idx));
	vo.setPw(pw);
	vo.setName(name);
	vo.setAge(Integer.parseInt(age));
	vo.setAddr(addr);
	
	MemberDao dao = MemberDao.getInstance();
	int result = dao.update(vo);
	pageContext.setAttribute("result", result);
%>

<c:choose>
	<c:when test="${result > 0}">
		<script type="text/javascript">
			alert("등록에 성공하였습니다.");
			location.href="view_all.jsp";
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("등록에 실패해였습니다");
			location.href="view_all.jsp";
		</script>
	</c:otherwise>
</c:choose>