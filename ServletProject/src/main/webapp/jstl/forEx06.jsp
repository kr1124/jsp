<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	콤마와 도트를 구분자로 이용 : 
	<c:forTokens var="token" items="빨강색, 주황색,조란색.초록색.파랑색.남색,보라색" delims=",.">
<%-- 		<c:out value="${token }"/><br> --%>
		${token }<br>
	</c:forTokens>
</body>
</html>