<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>formatNumber, formatDate</title>
</head>
<body>
	number : 
	<fmt:formatNumber type="number" value="12345.678"/> <br>
	currency : 
	<fmt:formatNumber type="currency" value="12345.678" currencySymbol="$"/> <br>
	percent : 
	<fmt:formatNumber type="percent" value="12345.678"/> <br>
	pattern = ".0" : 
	<fmt:formatNumber pattern=".0" value="12345.678"/> <br>
	
	<c:set var="now" value="<%=new java.util.Date() %>"/>
	<c:out value="${now }"/> <br>
	
	date : <fmt:formatDate value="${now }" type="date"/> <br>
	time : <fmt:formatDate value="${now }" type="time"/> <br>
	both : <fmt:formatDate value="${now }" type="both"/> <br>
	
	
</body>
</html>