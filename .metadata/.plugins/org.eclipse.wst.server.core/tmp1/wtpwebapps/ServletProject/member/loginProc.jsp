<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="com.member.StudentDAO"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<link href="style.css" rel="stylesheet" type="text/css" >
</head>
<body>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	int check = dao.loginCheck(id, pass);
	
	if(check == 1) {
		session.setAttribute("loginID", id); //session에 아이디 기록
		response.sendRedirect("login.jsp");
	}
	else if(check == 0) {
%>
	<script type="text/javascript">
		alert("비밀번호가 틀렸습니다.");
		history.go(-1);
	</script>
<%} else if(check == -1) { %>
	<script type="text/javascript">
		alert("존재하지 않는 아이디 입니다.");
		history.go(-1);
	</script>
<%} %>
	
</body>
</html>