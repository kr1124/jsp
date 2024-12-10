<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h2>JSP Script</h2>
	<%
		//script - 연산, 처리
		String scriptlet = "스크립트릿입니다.";
		String comment = "주석문입니다.";
		out.println("내장객체를 이용한 출력 : " + declation + "<br>");
		
	%>
	선언문 출력하기(변수) : <%=declation%><br>
	선언문 출력하기(메소드) : <%=declationMethod()%><br>
	스크립트릿 출력하기 : <%=scriptlet%><br>
	
	<!-- jsp에서 사용하는 html 주석 -->
	<!-- html 주석 : <%= comment %> --><br>
	<%-- jsp의 주석 : <%= comment %> --%>
	<%! //declation 선언
		String declation = "선언문 입니다.";
	%>
	
	<%!
		public String declationMethod() {
			return declation;
		}
	%>
	
</body>
</html>