<%@ page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.jdbc.*" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DBCP를 활용한 데이터베이스 연동</title>
		<link href="style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<h2>DBCP를 활용한 데이터베이스 연동</h2>
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
			
			<jsp:useBean id="dao" class="com.jdbc.TempMemberDAO" scope="page"/>
			<%
				Vector<TempMemberVO> vlist = dao.getMemberList();
				int counter = vlist.size();
				
				for(int i = 0; i < vlist.size(); i++) {
					TempMemberVO vo = vlist.elementAt(i);
			%>
			
			<tr>
				<td><strong><%=vo.getId() %></strong></td>
				<td><strong><%=vo.getPasswd() %></strong></td>
				<td><strong><%=vo.getName() %></strong></td>
				<td><strong><%=vo.getMem_num1() %></strong></td>
				<td><strong><%=vo.getMem_num2() %></strong></td>
				<td><strong><%=vo.getE_mail() %></strong></td>
				<td><strong><%=vo.getPhone() %></strong></td>
				<td><strong><%=vo.getZipcode() %></strong></td>
				<td><strong><%=vo.getAddress() %></strong></td>
				<td><strong><%=vo.getJob() %></strong></td>
			<%}%>
					
			</tr>
		</table>
		
	</body>
</html>