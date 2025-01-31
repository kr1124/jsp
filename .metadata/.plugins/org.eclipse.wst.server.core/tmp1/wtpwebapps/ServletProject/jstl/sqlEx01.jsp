<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<sql:query var="rs" dataSource="jdbc/myOracle">
		select * from tempmember
	</sql:query>
	
	<table border="1">
	<%-- 	필드명 출력 --%>
		<tr>
			<c:forEach var="columnName" items="${rs.columnNames }">
				<th> <c:out value="${columnName }"/> </th>
			</c:forEach>
		</tr>
		<%-- 레코드 수 만큼 반복 작업한다. --%>
		<c:forEach var="row" items="${rs.rowsByIndex }">
			<tr>
				<%-- 레코드의 필드 수 만큼 반복한다. --%>
				<c:forEach var="column" items="${row}">
					<td>
						<%-- 해당 필드 값이 null값이 아닐 때 --%>
						<c:if test="${column != null }">
							<c:out value="${column }"/>
						</c:if>
						<%-- 해당 필드 값이 null값일 때 --%>
						<c:if test="${column == null }">
							&nbsp;
						</c:if>
					</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>