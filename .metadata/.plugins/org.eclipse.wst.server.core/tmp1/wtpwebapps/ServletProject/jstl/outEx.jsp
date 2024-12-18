<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>소스 보기</title>
</head>
<body>
	<% 
		FileReader reader = null;
		
		try {
			String path = request.getParameter("path");
			if(path == null) {
				path = "/jstl/outEx.jsp";
			}
			reader = new FileReader(getServletContext().getRealPath(path));
	%>
			<pre>
				소스 코드 : <%=path %>
				<c:out value="<%=reader %>"/>
			</pre>
	<%
		} catch(Exception e) {
			e.printStackTrace();
	%>
	<%
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch(IOException ie) {
					ie.printStackTrace();
				}
			}
		}
	%>
</body>
</html>