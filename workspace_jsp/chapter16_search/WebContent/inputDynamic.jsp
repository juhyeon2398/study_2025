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
				 			<option value="1">회원번호</option>
				 			<option value="2">부서명</option>
				 			<option value="3">성명</option>
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
				
			</table>
		</form>
	</div>
</body>

<script type="text/javascript">
	
	function search_employee(f) {
		if(!f.searchText.value){
			alert("검색어를 입력해주세요.");
			return;
		}
		
		f.action = "/chapter16_search/Controller";
		f.submit();
	}

</script>
</html>