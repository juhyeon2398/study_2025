package org.joonzis.service;

import java.util.List;
import java.util.Map;

import org.joonzis.dao.EmployeeDao;
import org.joonzis.dao.EmployeeDaoImpl;
import org.joonzis.vo.EmployeeVO;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao dao = EmployeeDaoImpl.getInstance();

	@Override
	public List<EmployeeVO> getAll() {
		return dao.getAllEmployees();
	}
	@Override
	public List<EmployeeVO> getDepartmentId() {
		return dao.getDepartmentId();
	}
	@Override
	public List<EmployeeVO> getSearchEmployees(String departId) {
		return dao.getSearchEmployees(departId);
	}
	
	@Override
	public List<EmployeeVO> getFilter(Map<String, String> map) {
		return dao.getFilter(map);
	}
}


