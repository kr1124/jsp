<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="view/color.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>My Board</title>
	<link href="style.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="script.js"></script>
</head>
<!-- 새글/답글 구분, 이때 writeForm.jsp를 새글인지 아니면 답글인지 구분해야함 
	새글일 경우 num=0을 넘겨줄 것이고, 답글일 경우 원본글의 num을 받아와서 넘겨줌
	이를 통해 새글인지 답글인지 구분 
-->

<body bgcolor="${bodyback_c }" >
	<div align="center"><b>글쓰기</b></div><br>
	<form action="/boardmvc/writeProc.bdo" method="post" name="writeForm" onsubmit="return writeSave()">
		<!-- 글쓰기 버튼을 클릭해 writeProc.jsp로 페이지를 이동할 때에도 
			num, ref, step, depth의 값을 가지고 가야하므로 hidden으로 넘겨줌
		 -->
		<input type="hidden" name="num" value="${num }" >
		<input type="hidden" name="ref" value="${ref }" >
		<input type="hidden" name="step" value="${step }" >
		<input type="hidden" name="depth" value="${depth }" >
		
		<table width="400" border="1" cellpadding="0" cellsapacing="0" align="center" bgcolor="${bodyback_c }">
			<tr>
				<td align="right" colspan="2" bgcolor="${value_c }">
					<a href="/boardmvc/list.bdo">글목록</a>
				</td>
			</tr>

			<tr>
				<td width="70" bgcolor="${value_c }" align="center">이름</td>
				<td width="330">
					<input type="text" size="12" maxlength="12" name="writer">
				</td>
			</tr>

			<tr>
				<td width="70" bgcolor="${value_c }" align="center">이메일</td>
				<td width="330">
					<input type="text" size="40" maxlength="40" name="email">
				</td>
			</tr>

			<tr>
				<td width="70" bgcolor="${value_c }" align="center">제목</td>
				<td width="330">
					<c:if test="${num == 0 }">
						<input type="text" size="50" maxlength="50" name="subject">
					</c:if>
					<c:if test="${num != 0 }">
						<input type="text" size="50" maxlength="50" name="subject" value="답변">
					</c:if>
				</td>
			</tr>

			<tr>
				<td width="70" bgcolor="${value_c }" align="center">내용</td>
				<td width="330">
					<textarea name="content" id="" cols="50" rows="20"></textarea>
				</td>
			</tr>
			
			<tr>
				<td width="70" bgcolor="${value_c }" align="center">비밀번호</td>
				<td width="330">
					<input type="password" size="10" maxlength="10" name="pass">
				</td>
			</tr>

			<tr>
				<td colspan="2" bgcolor="${value_c }" align="center">
					<input type="submit" value="글쓰기">
					<input type="reset" value="다시작성">
					<input type="button" value="글목록" onclick="window.location='/boardmvc/list.bdo'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>