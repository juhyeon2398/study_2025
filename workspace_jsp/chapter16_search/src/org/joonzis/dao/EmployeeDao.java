package org.joonzis.dao;

import java.util.List;
import java.util.Map;

import org.joonzis.vo.EmployeeVO;

public interface EmployeeDao {
	public List<EmployeeVO> getAllEmployees();
	public List<EmployeeVO> getDepartmentId();
	public List<EmployeeVO> getSearchEmployees(String departId);
	public List<EmployeeVO> getFilter(Map<String, String> map);
}