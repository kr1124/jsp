<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="com.member.StudentDAO"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" http-equiv="Refresh" content="3;url=login.jsp"><!-- 이게 3초 -->
	<title>회원탈퇴</title>
	<link href="style.css" rel="stylesheet" type="text/css" >
</head>

<body>
<%
	String id = (String)session.getAttribute("loginID");
	String pass = request.getParameter("pass");
	
	int check = dao.deleteMember(id, pass);
	
	if(check == 1) {//삭제 완료
		session.invalidate();
%>
	<div align="center">
		<font size="5" face="궁서체">
			<b>탈퇴 처리되었습니다.</b><br>
			이용해주셔서 감사합니다.<br>
			3초 후에 Login 페이지로 이동합니다.
		</font>
	</div>
<%} else { %>
	<script type="text/javascript">
		alert("비밀번호가 맞지 않습니다.");
		history.go(-1);
	</script>
<%} %>	
</body>
</html>