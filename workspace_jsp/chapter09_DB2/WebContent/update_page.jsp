<%@page import="org.joonzis.db.DBConnect"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="index.jsp" />

	<br>
	<hr>
	<br>

	<%
		String id = request.getParameter("id");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
			conn = DBConnect.getConnection();
			String sql = "select * from member where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
	%>
		<h1>member 테이블의 <%=id%>회원 데이터</h1>
		<form method="post">
			<table>
				<thead>
					<tr>
						<th>회원번호</th>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>이름</th>
						<th>나이</th>
						<th>주소</th>
						<th>가입일</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<%
							if (!rs.next()) {
						%>
						<td colspan="7">member 데이터가 없습니다.</td>
						<%
							} else {
						%>
						<td><input type="hidden" name="idx" value="<%=rs.getInt(1)%>"><%=rs.getInt(1)%></td>
						<td><%=rs.getString(2)%></td>
						<td><input type="text" name="pw" value="<%=rs.getString(3)%>"></td>
						<td><input type="text" name="name" value="<%=rs.getString(4)%>"></td>
						<td><input type="number" name="age" value="<%=rs.getInt(5)%>"></td>
						<td><input type="text" name="addr" value="<%=rs.getString(6)%>"></td>
						<td><%=rs.getDate(7)%></td>
						<%
							}
						%>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="7">
							<input type="button" value="수정" onclick="update(this.form)">&nbsp;&nbsp;
							<input type="reset" value="다시 작성">
						</td>
					</tr>
				</tfoot>
			</table>
			
		</form>
	
	
	<%	} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
		
			}
		}%>
</body>
<script type="text/javascript">
	function update(f) {
		if(!f.pw.value || !f.name.value || !f.age.value || !f.addr.value){
			alert("데이터를 모두 입력해주세요.");
			return;
		} 
		f.action = "update.jsp";
		f.submit();
	}
</script>

</html>







