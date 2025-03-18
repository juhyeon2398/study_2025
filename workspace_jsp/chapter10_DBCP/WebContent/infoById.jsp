<%@page import="org.joonzis.ex.MemberDao"%>
<%@page import="org.joonzis.ex.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
		
	MemberVO vo = new MemberVO();
	vo.setId(id);
	vo.setPw(pw);
	
	MemberDao dao = MemberDao.getInstance();
	
%>