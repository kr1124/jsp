<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" http-equiv="Refresh" content="3;url=login.jsp"><!-- 이게 3초 -->
	<title>로그아웃</title>
	<!-- <link rel="stylesheet" href="style.css" type="text/css"> -->
</head>
<body>
	<div align="center">
		<font size="5" face="궁서체">
			<b>로그아웃되었습니다.</b><br>
			3초 후에 Login 페이지로 이동합니다.
		</font>
	</div>
</body>
</html>