<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" http-equiv="Refresh" content="3;url=member.mdo?cmd=login.jsp"><!-- 이게 3초 -->
	<title>회원탈퇴</title>
	<link href="style.css" rel="stylesheet" type="text/css" >
</head>

<body>
	<c:if test="${check eq 1}">
		<div align="center">
			<font size="5" face="궁서체">
				<b>탈퇴 처리되었습니다.</b><br>
				이용해주셔서 감사합니다.<br>
				3초 후에 Login 페이지로 이동합니다.
			</font>
		</div>
	</c:if>
	<c:if test="${check eq 0}">
		<script type="text/javascript">
			alert("비밀번호가 맞지 않습니다.");
			history.go(-1);
		</script>
	</c:if>
</body>
</html>