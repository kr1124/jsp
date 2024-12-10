<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int bufferSize = out.getBufferSize();
	int remainSize = out.getRemaining();
	int usedSize = bufferSize - remainSize;
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		버퍼의 전체크기 : <%=bufferSize %>byte<br>
		사용한 버퍼의 크기 : <%=usedSize %>byte<br>
		남은 버퍼의 크기 : <%=remainSize %>byte<br>
	</body>
</html>