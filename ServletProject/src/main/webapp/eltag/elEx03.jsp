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
	<title>EL(Expression Language)</title>
</head>
<body>
	request의 name 속성 출력 : ${requestScope.name }<br>
	code 파라미터 : ${param.code } <br>
	
</body>
</html>