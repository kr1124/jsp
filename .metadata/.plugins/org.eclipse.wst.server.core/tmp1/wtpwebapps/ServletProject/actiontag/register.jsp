<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>고객 가입 페이지</title>
	</head>
	<body>
		<form action="add.jsp" method="post" >
			<table border="1" width="300">
				<tr>
					<td width="100">이름</td>
					<td width="200"><input type="text" name="name" size="25"></td>
				</tr>
				<tr>
					<td width="100">이메일</td>
					<td width="200"><input type="email" name="email" size="25"></td>
				</tr>
				<tr>
					<td width="100">전화번호</td>
					<td width="200"><input type="text" name="phone" size="25"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" name="회원가입">
					</td>
				</tr>
				
				
				
			</table>
		</form>
	</body>
</html>