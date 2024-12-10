<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="1kb" autoFlush="false"%>
<%--
	buffer
		- jsp 페이지의 출력 버퍼의 크기를 설정. 기본 8kb
		- buffer 속성 none으로 설정되면, JspWriter 객체를 이용한 출력 버퍼시 버퍼를 이용하지 않는다.
		  즉, JSP 페이지로부터 출력되는 모든 내용은 즉시 사용자에게 응답함
	
	autoFlush
		- 버퍼가 다 찼을 경우 자동으로 비울것인가, 아닌가를 정함
		- 기본값은 true
		- autoFlush 속성이 true로 설정되면, 버퍼가 다 찼을 경우 자동으로 비워지고,
		  버퍼의 내용을 웹 브라우저로 전송한다.
		- false인 경우에는 버퍼가 다 찼을 경우 처리중인 jsp 페이지를 중단하고 예외가 발생됨
		- buffer 속성이 none으로 설정되면, autoFlush는 false로 할 수 없다.
			-> 버퍼가 없으니 예외도 없음
	
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<!-- 4KB 이상의 데이터 발생 -->
	<%
		for(int i = 0; i < 1000; i++) {%>
			1234
		<%}
	%>
</body>
</html>