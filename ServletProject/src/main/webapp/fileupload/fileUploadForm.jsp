<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>FileUpload Form</title>
</head>
<body>
	<div align="center">
		<form action="fileUpload.jsp" method="post" enctype="multipart/form-data">
			<table border="1">
				<tr>
					<td align="center" colspan="2"><h3>파일 업로드</h3></td>
				</tr>
				<tr>
					<td>올린 사람</td>
					<td>
						<input type="text" name="name">
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" name="subject">
					</td>
				</tr>
				<tr>
					<td>파일명 1</td>
					<td>
						<input type="file" name="fileName1">
					</td>
				</tr>
				<tr>
					<td>파일명 2</td>
					<td>
						<input type="file" name="fileName2">
					</td>
				</tr>

				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="전송">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>