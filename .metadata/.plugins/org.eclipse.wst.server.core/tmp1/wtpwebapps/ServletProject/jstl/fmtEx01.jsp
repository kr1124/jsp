<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- 언어 설정 -->
<fmt:setLocale value="en"/>

<fmt:bundle basename="bundle.testBundle">
<fmt:message key="TITLE" var="title"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${title }</title>
</head>
<body>
	<fmt:message key="NAME"/>
	<br>
	<c:if test="${! empty param.id }">
		<fmt:message key="MESSAGE">
			<fmt:param value="${param.id }"></fmt:param>
		</fmt:message>
	</c:if>
	
</body>
</html>

</fmt:bundle>