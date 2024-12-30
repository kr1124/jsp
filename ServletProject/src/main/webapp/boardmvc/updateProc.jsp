<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${check == 1 }">
	<meta http-equiv="refresh" content="0;url=/boardmvc/list.bdo?pageNum=${pageNum}">
</c:if>
<c:if test="${check == 0 }">
	비밀번호가 틀립니다.
	<br>
	<a href="javascript:history.go(-1)">글 수정폼으로 돌아가기</a>

	<script type="text/javascript">
// 		alert("비밀번호가 맞지 않습니다.");
// 		history.go(-1);
	</script>
</c:if>