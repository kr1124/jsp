<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="dao" class="com.member.StudentDAO"/>
<%-- <jsp:useBean id="vo" class="com.member.StudentVO"/>
<jsp:setProperty property="*" name="vo" /> --%>

<jsp:useBean id="vo" class="com.member.StudentVO">
	<jsp:setProperty property="*" name="vo" />
</jsp:useBean>

<%
	boolean flag = dao.memberInsert(vo);
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입 확인</title>
	<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body bgcolor="#ffffcc">
	<br>
	<div align="left">
		<%
		if (flag) {
			out.println("<b>회원가입을 축하합니다.</b><br>");
			out.println("<a href=login.jsp>로그인</a>");
		}
		else {
			out.println("<b>다시 입력하여 주십시오.</b><br>");
			out.println("<a href=regForm.jsp>로그인</a>");
		}
		%>
	</div>
</body>
</html>