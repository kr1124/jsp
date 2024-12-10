<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- writeForm.jsp에서 num, ref, step, depth를 받아서
	실제로 데이터베이스에 입력해야함 -->
<%@ page import="com.board.BoardDAO" %>
<%@ page import="java.sql.Timestamp" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="article" class="com.board.BoardVO" scope="page">
	<jsp:setProperty name="article" property="*"/>
</jsp:useBean>

<%
article.setRegdate(new Timestamp(System.currentTimeMillis()));
article.setIp(request.getRemoteAddr());
BoardDAO dbPro = BoardDAO.getInstance(); //db 연결
dbPro.insertArticle(article);
response.sendRedirect("list.jsp");
%>