<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.jstl.MemberVO" %>
<% 
	MemberVO vo1 = new MemberVO("손오공", "son@naver.com", 500);
	MemberVO vo2 = new MemberVO("사오정", "sao@naver.com", 170);
	MemberVO vo3 = new MemberVO("저팔계", "pal@naver.com", 100);

	ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
	memberList.add(vo1);
	memberList.add(vo2);
	memberList.add(vo3);
	request.setAttribute("memberList", memberList);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<h3>회원정보</h3>
	<table border="1" width="450">
		<tr>
			<th width="50">번호</th>
			<th width="100">이름</th>
			<th width="200">메일</th>
			<th width="100">나이</th>
		</tr>
		<c:forEach var="member" items="${memberList }" varStatus="num">
			<tr>
				<td style="align-content: center;"><p>${num.count }</p></td>
				<td style="align-items: center;"><p>${member.name}</p></td>
				<td style="margin: auto;">${member.email}</td>
				<td style="text-align: center;">${member.age}</td>
				
<%-- 				<td align="center">${num.count }</td> --%>
<%-- 				<td align="center">${member.name}</td> --%>
<%-- 				<td align="center">${member.email}</td> --%>
<%-- 				<td align="center">${member.age}</td> --%>
			</tr>
		</c:forEach>
	</table>
</body>
</html>