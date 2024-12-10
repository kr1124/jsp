<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="dao" class="com.member.StudentDAO"/>
<jsp:useBean id="vo" class="com.member.StudentVO">
	<jsp:setProperty property="*" name="vo" />
</jsp:useBean>

<%
	String loginID = (String)session.getAttribute("loginID");
	vo.setId(loginID);
	dao.updateMember(vo);	
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" http-equiv="Refresh" content="3;url=login.jsp"><!-- 이게 3초 -->
	<title>회원정보 수정 처리</title>
	<!-- <link rel="stylesheet" href="style.css" type="text/css"> -->
</head>
<body>
	<div align="center">
		<font size="5" face="궁서체">
			입력된 내용으로 <b>회원정보가 수정되었습니다.</b><br>
			3초 후에 Login 페이지로 이동합니다.
		</font>
	</div>
</body>
</html>