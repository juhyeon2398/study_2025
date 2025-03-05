<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- form을 이용하여 이름, 국어 ,영어 ,수학 점수 전달 -->
	<!-- name, kor, eng, mat 파라미터를 이용  -->
	<form>
		<ul>
			<li>이름 &emsp;&emsp;: <input type="text" name="name"></li>
			<li>국어 점수 : <input type="number" name="kor"></li>
			<li>영어 점수 : <input type="number" name="eng"></li>
			<li>수학 점수 : <input type="number" name="mat"></li>
		</ul>
		<button type="button" onclick="send(this.form);">전송</button>
	</form>	

</body>
<script type="text/javascript">
	function send(f) {
		if(f.name.value == ""){
			alert("이름을 작성해주세요.")
			return;
		}
		if(f.kor.value == ""){
			alert("국어점수를 입력해주세요.");
			return;
		}
		if(f.eng.value == ""){
			alert("영어점수를 입력해주세요.");
			return;
		}
		if(f.mat.value == ""){
			alert("수학점수를 입력해주세요.");
			return;
		}

		f.action = "Ex05_servlet";
		f.submit();
	}
</script>
</html>