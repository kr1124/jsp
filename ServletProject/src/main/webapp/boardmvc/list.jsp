<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="view/color.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<link href="style.css" type="text/css" rel="stylesheet" >
	<script type="text/javascript" src="script.js"></script>
</head>
<body bgcolor="${bodyback_c }">
	<div align="center">
		<b>글목록(전체 글 : ${count })</b>
		<table width="700" border="0" bgcolor="${value_c }">
			<tr>
				<td align="left">
					<a href="/boardmvc/list.bdo">전체목록</a>
				</td>
				<td align="right">
					<a href="/boardmvc/writeForm.bdo">글쓰기</a>
				</td>
			</tr>
		</table>
	<c:if test="${count eq 0 }">
		<table style="width: 700; border: 1;" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">
					게시판에 저장된 글이 없습니다.
				</td>
			</tr>
		</table>
	</c:if>
	<c:if test="${count > 0 }">
		<table style="width: 700; align-items: center;" border="1"  cellpadding="0" cellspacing="0">
			<tr height="30" bgcolor="${value_c }">
				<td align="center" width="50">번호</td>
				<td align="center" width="250">제목</td>
				<td align="center" width="100">작성자</td>
				<td align="center" width="150">작성일</td>
				<td align="center" width="50">조회수</td>
				<td align="center" width="100">IP</td>
			</tr>
		  <c:forEach var="article" items="${articleList }">
			<tr height="30">
				<td align="center" width="50">
					<c:out value="${number }"/>
					<c:set var="number" value="${number - 1 }"/>
				</td>
				<td width="250">
				
				  <c:if test="${article.depth > 0 }">
					<img src="img/level.gif" width="${5 * article.depth }" height="16">
					<img src="img/re.gif" >
				  </c:if>
				  <c:if test="${article.depth == 0 }">
					<img src="img/level.gif" width="${5 * article.depth }" height="16">
				  </c:if>
				
					<a href="/boardmvc/content.bdo?num=${article.num}&pageNum=${currentPage}">
						${article.subject}
					</a>
				  <c:if test="${article.readcount >= 20 }">
					<img src="img/hot.gif" border="0" height="16">
				  </c:if>
				</td>
				<td align="center" width="100">
					<a href="mailto:${article.email}">
						${article.writer}
					</a>
				</td>
				<td align="center" width="150">
					${article.regdate}
				</td>
				<td align="center" width="50">
					${article.readcount}
				</td>
				<td align="center" width="100">
					${article.ip}
				</td>
			</tr>
		  </c:forEach>
		</table>
	</c:if>
		
	<c:if test="${count > 0 }">
		<c:set var="imsi" value="${count % pageSize == 0 ? 0 : 1 }"/>
		<c:set var="pageCount" value="${count / pageSize + imsi }"/>
		<c:set var="pageBlock" value="${3 }"/>

		<fmt:parseNumber var="result" value="${(currentPage - 1) / pageBlock }" integerOnly="true"/>

		<c:set var="startPage" value="${result * pageBlock + 1 }"/> <!-- 시작 페이지 -->
		<c:set var="endPage" value="${startPage + pageBlock - 1 }"/> <!-- 마지막 페이지 -->
		
		<c:if test="${endPage > pageCount }">
			<c:set var="endPage" value="${pageCount }"/> <!-- 마지막으로 보여줄 페이지 -->
		</c:if> 
		<c:if test="${startPage > pageBlock }"> <!--페이지 블럭을 이전과 다음으로 처리함-->
				<a href="#" onclick="frm_sub(${startPage - pageBlock})">[이전]</a>
<%-- 			<c:if test="${searchText == null }"> --%>
				
<%-- 					<a href="/boardmvc/list.bdo?pageNum=<%=startPage - pageBlock%>&searchWhat=<%=searchWhat%>&searchText=<%=searchText%>">[이전]</a> --%>

				
				
				
		</c:if> 
		
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<a href="#" onclick="frm_sub(${i})">[${i }]</a>
<%-- 				<c:if test="${searchText == null }"> --%>
<%-- 					<a href="/boardmvc/list.bdo?pageNum=${i }">[${i }]</a> --%>
<%-- 				</c:if> --%>
<%-- 				<c:if test="${searchText != null }"> --%>
<%-- 					<a href="/boardmvc/list.bdo?pageNum=${i }&searchWhat=${searchWhat }&searchText=${searchText }">[${i }]</a> --%>
<%-- 				</c:if> --%>
		</c:forEach>
		
		<c:if test="${endPage < pageCount }">
			<a href="#" onclick="frm_sub(${startPage + pageBlock})">[다음]</a>
<!-- 			if(searchText == null) -->
<%-- 				<a href="list.jsp?pageNum=<%=startPage + pageBlock%>&searchWhat=<%=searchWhat%>&searchText=<%=searchText%>">[다음]</a> --%>

		</c:if> 
		
	</c:if>
	
		<!--검색 폼 -->
		<form action="" name="i_frm" method="post">
			<input type="hidden" name="find_box" value="${find_box }">
			<input type="hidden" name="find" value="${find }">
		</form>
	
		<form action="/boardmvc/list.bdo" onsubmit="return check()" method="post">
			<select name="find" size="1">
				<option value="writer">이름</option>
				<option value="subject">제목</option>
				<option value="content">내용</option>
			</select>
			&nbsp;
			<input type="text" name="find_box">
			&nbsp;
			<input type="submit" value="검색">
		</form>
	</div>
</body>
</html>