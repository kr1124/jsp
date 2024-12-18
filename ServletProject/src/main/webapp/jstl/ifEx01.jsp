<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<c:if test="${3 > 4 }">
		이 내용은 화면에 나타나지 않습니다.
	</c:if>
	<c:if test="${param.type eq 'guset' }">
		홈페이지 방문을 환영합니다. <br>
		더 많은 서비스를 위해 회원가입해주시기 바랍니다.
	</c:if>
	<c:if test="${param.type eq 'member' }">
		회원님의 홈페이지 방문을 환영합니다.
	</c:if>
</body>
</html>