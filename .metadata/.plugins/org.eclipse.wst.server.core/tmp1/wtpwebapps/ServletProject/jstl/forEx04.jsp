<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	HashMap<String, Object> mapData = new HashMap<String, Object>();

	mapData.put("name", "홍길동");
	mapData.put("today", new Date());
%>
<c:set var="intArray" value="<%= new Integer[]{1,2,3,4,5} %>"/>
<c:set var="map" value="<%=mapData %>"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<h4>int 형 배열</h4>
	<c:forEach var="i" items="${intArray }" begin="2" end="4">
		[${i }]<br>
	</c:forEach>
	
	<h4>Map</h4>
	<c:forEach var="i" items="${map }">
		${i.key } = ${i.value}<br>
	</c:forEach>
	
	<h4>99</h4>
	<c:forEach begin="1" end="9" step="1" var="i">
		<c:forEach begin="1" end="9" step="1" var="j">
			${j } X ${i } = ${i * j }&nbsp;&nbsp;
		</c:forEach>
		<br>
	</c:forEach>
	
	<h4>1~100의 홀수의 합계</h4>
	<c:set var="sum" value="0"/>
	<c:forEach begin="1" end="100" step="2" var="i">
		<c:set var="sum" value="${sum + i }"></c:set>
	</c:forEach>
	결과 : ${sum }
</body>
</html>