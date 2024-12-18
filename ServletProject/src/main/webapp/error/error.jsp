<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<% response.setStatus(HttpServletResponse.SC_OK); %>
<%--
	JSP 페이지에서 Throwable 객체인 exception을 사용할 것인지를 정한다.
	기본값은 false
	isErrorPage 속성을 true로 설정하면 현재 jsp페이지에서 exception 객체를 사용할수 있고,
					 false면 사용할 수 없다.
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외 발생</title>
</head>
<body>
	요청 처리 과정에서 예외가 발생하였습니다.<br>
	빠른 시간내에 문제를 해결하도록 하겠습니다.<br>
	<br>
	에러 타입 : <%=exception.getClass().getName() %><br>
	에러 메시지 : <b><%=exception.getMessage()%></b>
</body>
</html>