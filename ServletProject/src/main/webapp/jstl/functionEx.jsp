<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>함수 사용</title>
</head>
<body>
	<c:set var="str1" value="Function 태그를 사용합니다."/>
	<c:set var="str2" value="사용"/>
	<c:set var="tokens" value="1,2,3,4,5,6,7,8,9,10"/>
	
	length(str1) = ${fn:length(str1) } <br>
	toUpperCase(st1) = ${fn:toUpperCase(str1) } <br>
	toLowerCase(st1) = ${fn:toLowerCase(str1) } <br>
	subString(str1, 3, 6) = ${fn:substring(str1, 3, 6) } <br>
	substringAfter(str1, str2) = ${fn:substringAfter(str1, str2) } <br>
	substringBefore(str1, str2) = ${fn:substringBefore(str1, str2) } <br>
	trim(str1) = ${fn:trim(str1) } <br>
	replace(str1, src, dest) = ${fn:replace(str1, " ", "-") } <br>
	indexOf(str1, str2) = ${fn:indexOf(str1, str2) } <br>
	
	<c:set var="array" value="${fn:split(tokens, ',') }"/>
	join(array, "-") = ${fn:join(tokens, ',') } <br>
	
</body>
</html>