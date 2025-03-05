<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get">
		검색 <input type="text" name="query">
		<input type="button" value="전송" onclick="send(this.form);"> 
	</form>
</body>
<script type="text/javascript">
	function send(f) {
		if(f.query.value == ''){
			alert("검색 내용을 입력하세요.");
			return;
		}
		// f.action = '/chapter03_servlet/Ex03_servlet';
		f.action = 'Ex03_servlet';
		f.submit();
	}
</script>
</html>