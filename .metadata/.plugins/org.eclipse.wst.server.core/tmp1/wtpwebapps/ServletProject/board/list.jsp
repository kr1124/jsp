<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.board.BoardDAO" %>
<%@ page import="com.board.BoardVO" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ include file="view/color.jsp" %>

<%!
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<%
	int count = 0;
	int number = 0;
	List<BoardVO> articleList = null;
	BoardDAO dbPro = BoardDAO.getInstance();
	
	count = dbPro.getArticleCount();
	
	if(count > 0) {
		articleList = dbPro.getArticles();
	}
	number = count;
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<link href="style.css" type="text/css" rel="stylesheet" >
</head>
<body bgcolor="<%=bodyback_c%>">
	<div align="center">
		<b>글목록(전체 글 : <%=count%>)</b>
		<table width="700">
			<tr>
				<td align="right" bgcolor="<%=value_c%>">
					<a href="writeForm.jsp">글쓰기</a>
				</td>
			</tr>
		</table>
	<%if(count == 0) { %>
		<table style="width: 700; border: 1;" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">
					게시판에 저장된 글이 없습니다.
				</td>
			</tr>
		</table>
	<%} else {%>
		<!-- <table style="width: 700; border: 1; align-items: center" cellpadding="0" cellspacing="0"> -->
		<table style="width: 700; align-items: center;" border="1"  cellpadding="0" cellspacing="0">
			<tr height="30" bgcolor="<%=value_c%>">
				<td align="center" width="50">번호</td>
				<td align="center" width="250">제목</td>
				<td align="center" width="100">작성자</td>
				<td align="center" width="150">작성일</td>
				<td align="center" width="50">조회수</td>
				<td align="center" width="100">IP</td>
			</tr>
			<%
			for(int i = 0; i < articleList.size(); i++) {
				BoardVO article = (BoardVO)articleList.get(i);
			%>
			<tr height="30">
				<td align="center" width="50"><%=number-- %></td>
				<td width="250">
					<a href="content.jsp?num=<%=article.getNum()%>&pageNum1">
						<%=article.getSubject() %>
					</a>
					<% if(article.getReadcount() >= 20) { %>
					<img src="img/hot.gif" border="0" height="16">
					<%} %>
				</td>
				<td align="center" width="100">
					<a href="mailto:<%=article.getEmail()%>">
						<%=article.getWriter() %>
					</a>
				</td>
				<td align="center" width="150">
					<%=sdf.format(article.getRegdate()) %>
				</td>
				<td align="center" width="50">
					<%=article.getReadcount() %>
				</td>
				<td align="center" width="100">
					<%=article.getIp() %>
				</td>
			</tr>
			
			<%}%>
		</table>
<%} %>
	</div>
</body>
</html>