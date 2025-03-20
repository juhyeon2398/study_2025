package org.joonzis.service;

import java.util.List;
import java.util.Map;

import org.joonzis.vo.EmployeeVO;

public interface EmployeeService {
	public List<EmployeeVO> getAll();
	public List<EmployeeVO> getDepartmentId();
	public List<EmployeeVO> getSearchEmployees(String departId);
	public List<EmployeeVO> getFilter(Map<String, String> map);
}
