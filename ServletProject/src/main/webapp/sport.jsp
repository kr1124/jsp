<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>좋아하는 운동 및 성별</h1>
    <form action="Sport" method="post">
        <legend>좋아하는 운동 및 성별</legend>
        <ul>
            <li>
                <label>야구</label>
                <input type="checkbox" name="sports" value="야구">
                <label>축구</label>
                <input type="checkbox" name="sports" value="축구">
                <label>농구</label>
                <input type="checkbox" name="sports" value="농구">
            </li>
            <li>
                <label>남자</label>
                <input type="radio" name="gender" value="남자" checked="checked">
                <label>여자</label>
                <input type="radio" name="gender" value="여자">
            </li>
            <li>
                <input type="submit" value="전송">
            </li>
        </ul>
    </form>
    
</body>
</html>