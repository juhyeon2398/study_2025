package org.joonzis.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex04_servlet")
public class Ex04_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex04_servlet() {
        super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobbies");
		
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
		System.out.println("이름 : " + name);
		System.out.println("이메일 : " + email);
		System.out.println("성별 : " + gender);
		System.out.println("취미 : " + Arrays.toString(hobbies));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
