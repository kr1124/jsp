<%@page import="org.apache.catalina.util.CustomObjectInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.actiontag.Customer" %>
<%@ page import="java.util.HashMap" %>
<%-- 
	표현 언어
	- 값을 표현 한느데 사용하는 새로운 스크립트 언어
	
	표현언어에서 제공하는 기능
	1. JSP의 네가지 기본객체가 제공하는 영역의 속성의 사용
		application, request, response, page
		
	2. 집합 객체에 대한 접근 방법의 제공
	3. 수치연산, 관계연산, 논리연산 제공
	4. 자바클래스 메소드 호출 기능을 제공
	5. 표현언어만의 기본 객체 제공
	
	표현방법
	${ 표현식}
	표현식은 항상 중괄호로 묶고 제일 앞에 달러기호($)를 붙인다.
	
	형식
	${person.name}
	
	.(도트연산자)를 기준으로 왼쪽은 반드시 맵 또는 빈으로 표현함
	.(도트연산자)를 기준으로 오른쪽은 반드시 맵의 키이거나 빈의 프로퍼티여야 한다.
 --%>
 
 <%
 	Customer customer = new Customer();
 	customer.setName("손오공");
 	customer.setEmail("som@naver.com");
 	customer.setPhone("010-1234-5678");
 	request.setAttribute("customer", customer);
 	
 	HashMap<String, String> map = new HashMap<String, String>();
 	map.put("name", "소나타");
 	map.put("maker", "현대");
 	request.setAttribute("car", map);
 	
 %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>EL(Expression Language)</title>
</head>
<body>
	<ul>
		<li>이름 : ${customer.name }</li>
		<li>메일 : ${customer.email}</li>
		<li>전번 : ${customer.phone}</li>
	</ul>
</body>
</html>