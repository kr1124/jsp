<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String code = request.getParameter("code");
	
	String viewPageURI = null;

	if(code.equals("A")) {
		viewPageURI = "viewModule/a.jsp";
	}
	else if(code.equals("B")) {
		viewPageURI = "viewModule/b.jsp";
	}
	else if(code.equals("C")) {
		viewPageURI = "viewModule/c.jsp";
	}
	
	/* if(code.equals("A") || code.equals("B") || code.equals("C")) {
		viewPageURI = "viewModule/" + code.toLowerCase() + ".jsp";
	} */
%>
<jsp:forward page="<%=viewPageURI %>"/> 