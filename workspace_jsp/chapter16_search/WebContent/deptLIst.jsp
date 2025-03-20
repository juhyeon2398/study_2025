<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{
		width: 800px;
		text-align: center;
		margin: auto;
	}
	table{
		width: 100%;
		border-collapse: collapse;
	}
	th, td{
		border: 1px solid gray;
	}
	th{
		padding: 5px;
		background-color: darkslateblue;
		color: white;
	}
</style>
</head>
<body>
	<div>
		<form>
			<h1>부서를 선택하고 검색 버튼을 누르세요.</h1>
			<table>
				<tr>
				 	<th colspan="6"> 부서검색 </th>
				</tr>
				<tr>
				 	<td colspan="6">
				 		<select name="department_id">
				 			<option value="">::부서 선택::</option>
				 			<c:forEach var="vo" items="${list}">
				 				<option value="${vo.department_id}" >${vo.department_id}</option>
				 			</c:forEach>
				 		</select> 
				 		<input type="button" value="검색" onclick="search_dept(this.form)">
				 		<input type="hidden" name="cmd" value="deptList">
			 		</td>
				</tr>
				<c:forEach var="selectList" items="${selectList}">
	 				<tr>
	 					<td>${selectList.employee_id}</td>
						<td>${selectList.first_name}</td>
						<td>${selectList.phone_number}</td>
						<td>${selectList.salary}</td>
						<td>${selectList.department_id}</td>
						<td>${selectList.hire_date}</td>
	 				</tr>
	 			</c:forEach>
			</table>
		</form>
	</div>
</body>

<script type="text/javascript">
	function search_dept(f) {
		console.log(f.department_id.value)
		if(f.department_id.value == ""){
			alert("부서 번호를 선택해주세요");
			return;
		}
		
		f.action = "/chapter16_search/Controller";
		f.submit();
	}
</script>
</html>