<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<c:forTokens var="car" items="Sprinter Trueno AE86,Rx-7 Savanna FC3S, Lancer Evolution III,RX-" delims=",">
		자동차 이름 : <c:out value="${car }"/><br>
	</c:forTokens>
</body>
</html>