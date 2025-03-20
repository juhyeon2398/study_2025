package org.joonzis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joonzis.service.EmployeeService;
import org.joonzis.service.EmployeeServiceImpl;
import org.joonzis.vo.EmployeeVO;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String cmd = request.getParameter("cmd");
		String departId = request.getParameter("department_id");
		String searchFilter = request.getParameter("searchFilter");
		String searchText = request.getParameter("searchText");
		// 공용 자원
		String path = ""; // 이동경로
		EmployeeService service = new EmployeeServiceImpl(); // service 객체 생성
		List<EmployeeVO> list = null; // 리턴 객체
		List<EmployeeVO> selectList = null; // 리턴 객체
		Map<String, String> map = null;
		
		
		switch (cmd) {
		case "allList":
			list = service.getAll();
			request.setAttribute("list", list);
			path = "allList.jsp";
			break;
		case "inputDept":
			list = service.getDepartmentId();
			request.setAttribute("list", list);
			path = "inputDept.jsp";
			break;
		case "deptList":
			list = service.getDepartmentId();
			request.setAttribute("list", list);
			selectList = service.getSearchEmployees(departId);
			request.setAttribute("selectList", selectList);
			path = "deptLIst.jsp";
			break;
		case "inputDynamic":
			path = "inputDynamic.jsp";
			break;
		case "dynamicList":
			map = new HashMap<String, String>();
			map.put("searchFilter",searchFilter);
			map.put("searchText",searchText);
			list = service.getFilter(map);
			request.setAttribute("list", list);
			path = "dynamicList.jsp";
			break;
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
