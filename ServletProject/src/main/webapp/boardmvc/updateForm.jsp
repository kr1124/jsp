<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="view/color.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글 수정</title>
	<link href="style.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="script.js"></script>
</head>
<body bgcolor="${bodyback_c }" >
	<div align="center">
		<b>글 수정</b><br>
		<form action="/boardmvc/updateProc.bdo?pageNum=${pageNum }" method="post" name="writeForm" onsubmit="return writeSave()">			
			<table width="400" border="1" cellpadding="0" cellsapacing="0" align="center" bgcolor="${bodyback_c }">
				<tr>
					<td width="70" bgcolor="${value_c }" align="center">이름</td>
					<td width="330" align="left">
						<input type="text" size="10" maxlength="10" name="writer" value="${article.writer }">
						<input type="hidden" name="num" value="${article.num }">
					</td>
				</tr>
				<tr>
					<td width="70" bgcolor="${value_c }" align="center">제목</td>
					<td width="330" align="left">
						<input type="text" size="40" maxlength="50" name="subject" value="${article.subject }">
					</td>
				</tr>
				<tr>
					<td width="70" bgcolor="${value_c }" align="center">이메일</td>
					<td width="330" align="left">
						<input type="text" size="40" maxlength="40" name="email" value="${article.email }">
					</td>
				</tr>
				<tr>
					<td width="70" bgcolor="${value_c }" align="center">내용</td>
					<td width="330" align="left">
						<textarea name="content" rows="15" cols="40">${article.content }</textarea>
					</td>
				</tr>
				<tr>
					<td width="70" bgcolor="${value_c }" align="center">비밀번호</td>
					<td width="330" align="left">
						<input type="password" size="8" maxlength="12" name="pass">
					</td>
				</tr>
	
				<tr>
					<td colspan="2" bgcolor="${value_c }" align="center">
						<input type="submit" value="글 수정">
						<input type="reset" value="다시작성">
						<input type="button" value="글목록" onclick="document.location.href='/boardmvc/list.bdo?pageNum=${pageNum }'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>