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
			<h1>무엇을 검색 하시겠습니까?</h1>
			<table>
				<tr>
				 	<th colspan="6"> 검색옵션 </th>
				</tr>
				<tr>
				 	<td colspan="6">
				 		선택검색 : 
				 		<select name="searchFilter">
				 			<option value="">전체</option>
				 			<option value="1" ${ param.searchFilter eq 1 ? 'selected' : ''}>회원번호</option>
				 			<option value="2" ${ param.searchFilter eq 2 ? 'selected' : ''}>부서명</option>
				 			<option value="3" ${ param.searchFilter eq 3 ? 'selected' : ''}>성명</option>
				 		</select> 
		 			</td>
				</tr>
				<tr>
				 	<td colspan="6">
				 		입력 검색 : <input type="text" name="searchText">
			 		</td>
				</tr>
				<tr>
				 	<td colspan="6">
				 		<input type="button" value="검색" onclick="search_employee(this.form)">
				 		<input type="hidden" name="cmd" value="dynamicList">
			 		</td>
				</tr>
				
				<c:choose>
					<c:when test="${ not empty list}">
						<tr>
							<th>직원 ID</th>
							<th>이름</th>
							<th>연락처</th>
							<th>연봉</th>
							<th>부서 ID</th>
							<th>고용일</th>
						</tr>
						
						<c:forEach var="vo" items="${list}">
			 				<tr>
			 					<td>${vo.employee_id}</td>
								<td>${vo.last_name}</td>
								<td>${vo.phone_number}</td>
								<td>${vo.salary}</td>
								<td>${vo.department_id}</td>
								<td>${vo.hire_date}</td>
			 				</tr>
			 			</c:forEach>
					</c:when>
					<c:otherwise>
						<td colspan="6">
					 		검색 결과가 없습니다.
				 		</td>
					</c:otherwise>
				</c:choose>
			</table>
		</form>
	</div>
</body>

<script type="text/javascript">
 	const regExp = /^[0-9]+$/;
    const target = "";
	
	function search_employee(f) {
		if(!f.searchText.value){
			alert("검색어를 입력해주세요.");
			return;
		}
		
		f.action = "/chapter16_search/Controller";
		f.submit();
	}
	
	
//  let selector = document.querySelector("select[name='searchFilter']");
//	let searchText = document.querySelector("input[name='searchText']");
//	selector.addEventListener("change",function(){
//		if(this.value == 1 || this.value == 2){
//			searchText.setAttribute("type","number")
//		}else{
//			searchText.setAttribute("type","text")
//		}
//	})

</script>
</html>