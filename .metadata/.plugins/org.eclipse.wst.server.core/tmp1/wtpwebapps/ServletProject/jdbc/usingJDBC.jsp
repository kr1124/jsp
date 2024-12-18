<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.jdbc.*" %>
<!-- a -->
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String id = "id",
			passwd = "passwd",
			name = "name",
			mem_num1 = "mem_num1",
			mem_num2 = "mem_num2",
			e_mail = "email",
			phone = "phone",
			zipcode = "zipcode",
			address = "address",
			job = "address";
	int counter = 0;
	
	try {
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		stmt = con.createStatement();
		String sql = "select * from tempmember";
		rs = stmt.executeQuery(sql);
		
		int count = 0;
		
		if(rs!= null) {
			while(rs.next()) {
				id=rs.getString("id");
				passwd = rs.getString("passwd");
				name = rs.getString("name");
				mem_num1 = rs.getString("mem_num1");
				mem_num2 = rs.getString("mem_num2");
				e_mail = rs.getString("email");
				phone = rs.getString("phone");
				zipcode = rs.getString("zipcode");
				address = rs.getString("address");
				job = rs.getString("address");
			
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DB test</title>
		<link href="style.css" rel="stylesheet" type="text/css" >
	</head>
	<body>
		<h2>스크립트릿으로 데이터베이스 연동</h2>
		<h3>회원정보</h3>
		<table bordercolor="#0000ff" border="1" >
			<tr>
				<td><strong>ID</strong></td>
				<td><strong>PASSWORD</strong></td>
				<td><strong>NAME</strong></td>
				<td><strong>MEM_NUM1</strong></td>
				<td><strong>MEM_NUM2</strong></td>
				<td><strong>E_MAIL</strong></td>
				<td><strong>PHONE</strong></td>
				<td><strong>ZIPCODE</strong></td>
				<td><strong>ADDRESS</strong></td>
				<td><strong>JOB</strong></td>
			</tr>
			<tr>
				<td><strong><%=id %></strong></td>
				<td><strong><%=passwd %></strong></td>
				<td><strong><%=name %></strong></td>
				<td><strong><%=mem_num1 %></strong></td>
				<td><strong><%=mem_num2 %></strong></td>
				<td><strong><%=e_mail %></strong></td>
				<td><strong><%=phone %></strong></td>
				<td><strong><%=zipcode %></strong></td>
				<td><strong><%=address %></strong></td>
				<td><strong><%=job %></strong></td>
			<% 
				counter++;
			}
		}%>
			</tr>
		</table>
			
<%} catch(SQLException se) {
	se.printStackTrace();	
} catch(Exception e) {
	e.printStackTrace();
} finally {
	if(rs!=null) {rs.close();}
	if(stmt!=null) {stmt.close();}
	if(con!=null) {con.close();}
}

%>
	</body>
</html>