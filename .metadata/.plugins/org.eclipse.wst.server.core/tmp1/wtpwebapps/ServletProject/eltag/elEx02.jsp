<%@page import="org.apache.catalina.util.CustomObjectInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.actiontag.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<String> singer = new ArrayList<String>();
	singer.add("ㅁㄴㅇㄹ");
	singer.add("oijwfe");
	
	request.setAttribute("singer", singer);
	
	Customer[] customer = new Customer[2];
	customer[0] = new Customer();
	customer[0].setName("손오공");
 	customer[0].setEmail("som@naver.com");
 	customer[0].setPhone("010-1234-5678");
	customer[1] = new Customer();
	customer[1].setName("홍길동");
 	customer[1].setEmail("hong@naver.com");
 	customer[1].setPhone("010-5634-8988");
 	
 	request.setAttribute("customer", customer);
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>EL(Expression Language)</title>
</head>
<body>
	<ul>
		<li>이름 : ${singer[0]}, ${singer[1]}</li>
	</ul>
	<ul>
		<li>이름 : ${customer[0].name}</li>
		<li>메일 : ${customer[0].email}</li>
		<li>전번 : ${customer[0].phone}</li>
	</ul>
	<ul>
		<li>이름 : ${customer[1].name}</li>
		<li>메일 : ${customer[1].email}</li>
		<li>전번 : ${customer[1].phone}</li>
	</ul>
</body>
</html>