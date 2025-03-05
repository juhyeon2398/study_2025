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

@WebServlet("/Ex05_servlet")
public class Ex05_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex05_servlet() {
        super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		
		double avg = (kor + eng + mat) / 3.0;
		String str; 
		if(avg > 90) {
			str = "A";
		}else if(avg > 80) {
			str = "B";
		}else if(avg > 70) {
			str = "C";
		}else if(avg > 60) {
			str = "D";
		}else {
			str = "F";
		}
		
		System.out.println(name + "의 평균 점수는 " + avg + "이며 학점은 " + str);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
