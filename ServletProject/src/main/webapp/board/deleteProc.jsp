<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.board.BoardDAO" %>
<%@ page import="java.sql.*" %>
<% request.setCharacterEncoding("utf-8"); %>

<%
int num = Integer.parseInt(request.getParameter("num"));
String pass = request.getParameter("pass");
String pageNum = request.getParameter("pageNum");
BoardDAO dbPro = BoardDAO.getInstance();

int check = dbPro.deleteArticle(num, pass);

if(check == 1) {//삭제 성공
%>
	<script type="text/javascript">
		alert("삭제되었습니다.");
	</script>
	<meta http-equiv="refresh" content="0;url=list.jsp?pageNum=<%=pageNum%>">
<%} else if(check == 0) {%>
	<script type="text/javascript">
		alert("비밀번호가 맞지 않습니다.");
		history.go(-1);
	</script>
<%}%>
	