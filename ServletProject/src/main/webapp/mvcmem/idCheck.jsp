<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mvcmem.model.StudentDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ID 중복 체크</title>
		<link href="style.css" rel="stylesheet" type="text/css" >
	</head>
	<body bgcolor="#ffffcc">
		<br>
		<div align="center">
			<b> ${id } </b>
				<c:if test="${check == true }">
					는 이미 존재하는 ID입니다.<br>
				</c:if>
				<c:if test="${check == false }">
					는 사용 가능한 ID입니다.<br>
				</c:if>
			<a href="#" onclick="javascript:self.close()">닫기</a>
		</div>
	</body>
</html>