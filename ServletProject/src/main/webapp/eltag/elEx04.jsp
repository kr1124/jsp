<%@page import="org.apache.catalina.util.CustomObjectInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.actiontag.Customer" %>
<%
	request.setAttribute("name", "홍길동");
	
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>파라미터 값 처리</title>
</head>
<body>
	<form action="elEx04.jsp" method="post">
		이름 : <input type="text" name="name" value="${param['name'] }">
		<input type="submit" value="확인">
	</form>
	<p>이름은 ${param.name }입니다.</p>
</body>
</html>