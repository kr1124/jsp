<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="com.member.StudentDAO"/>
<%
    String id = request.getParameter("id");
	boolean check = dao.idCheck(id);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link href="style.css" rel="stylesheet" type="text/css" >
	</head>
	<body bgcolor="#ffffcc">
		<br>
		<div align="center">
			<b><%=id %></b>
			<%
				if(check) {
					out.println("는 이미 존재하는 ID입니다.<br>");
				}
				else {
					out.println("는 사용 가능한 ID입니다.<br>");
				}
			%>
			<a href="#" onclick="javascript:self.close()">닫기</a>
		</div>
	</body>
</html>