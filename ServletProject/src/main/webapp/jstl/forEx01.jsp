<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String[] movieList = {"asdf", "qwer", "zxcv"};
	request.setAttribute("movieList", movieList);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	적당한 단어 : 
		<ul>
			<c:forEach var="movie" items="${movieList }">
				<li>${movie }</li>
			</c:forEach>
		</ul>
</body>
</html>