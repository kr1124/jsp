<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.jdbc.*" %>
<!-- a -->
<%
	for(int i = 0; i < 10; i++) {
		
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
		<p><%=i %></p>
		<%} %>
	</body>
</html>