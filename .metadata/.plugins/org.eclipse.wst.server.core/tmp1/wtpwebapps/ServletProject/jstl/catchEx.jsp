<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<c:catch var="ex">
		name 파라미터의 값 : <%= request.getParameter("name") %><br>
		<%
			if(request.getParameter("name").equals("test")) {
		%>
				${param.name }은 test 입니다.
		<%
			}			
		%>
	</c:catch>
	<br>
	<c:if test="${ex ne null }">
		예외가 발생하였습니다. <br>
		${ex }
	</c:if>
</body>
</html>