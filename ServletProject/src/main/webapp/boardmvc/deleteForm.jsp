<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="view/color.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판</title>
	<link href="style.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="script.js"></script>
</head>

<body bgcolor="${bodyback_c }" >
	<div align="center">
		<b>글삭제</b><br>
		<form action="/boardmvc/deleteProc.bdo?pageNum=${pageNum }" method="post" name="delForm" onsubmit="return deleteSave()">
			<table width="360" border="1" cellpadding="0" cellsapacing="0" align="center">
				<tr height="30">
					<td align="center" bgcolor="${value_c }">
						<b>비밀번호를 입력해 주세요.</b>
					</td>
				</tr>
				<tr height="30">
					<td align="center">비밀번호
						<input type="password" name="pass" size="8" maxlength="12">
						<input type="hidden" name="num" value=${num }>
					</td>
				</tr>
				<tr height="30">
					<td align="center" bgcolor="${value_c }">
						<input type="submit" value="글삭제">
						<input type="button" value="글목록" onclick="document.location.href='/boardmvc/list.bdo?pageNum=${pageNum }'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>