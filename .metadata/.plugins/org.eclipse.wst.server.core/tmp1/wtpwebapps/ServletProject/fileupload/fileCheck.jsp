<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String filename1 = request.getParameter("filename1");
	String filename2 = request.getParameter("filename2");
	String origfilename1 = request.getParameter("origfilename1");
	String origfilename2 = request.getParameter("origfilename2");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>파일 업로드 확인</title>
</head>
<body>
	올린사람 : <%=name %><br>
	제목 : <%=subject %><br>
	파일 1 : <a href="/upload/<%=filename1%>"><%=origfilename1 %></a><br>
	파일 2 : <a href="/upload/<%=filename2%>"><%=origfilename2 %></a>
	
</body>
</html>