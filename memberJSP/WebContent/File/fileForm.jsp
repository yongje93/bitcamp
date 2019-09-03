<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form name="" enctype="multipart/form-data" method="post" action="fileUpload.jsp">
	 <table border="1" cellspacing="0" cellpadding="5">
	 	<tr>
	 		<td width="80" align="center">제목</td>
	 		<td width="200"><input type="text" id="subject" name="subject" style="width: 250px;"></td>
	 	</tr>
	 	<tr>
	 		<td width="80" align="center">내용</td>
	 		<td>
	 		 <textarea id="content" name="content" cols="40" rows="10" style="resize: none"></textarea>
	 		</td>
	 	</tr>
	 	<tr>
	 		<td colspan="2">
	 		<input type="file" name="upload1" size="50">
	 		</td>
	 	</tr>
	 	<tr>
	 		<td colspan="2">
	 		<input type="file" name="upload2" size="50">
	 		</td>
	 	</tr>
	 	<tr>
	 		<td colspan="2" align="center">
	 			<input type="submit" value="파일업로드">
	 			<input type="reset" value="다시작성">
	 		</td>
	 	</tr>
	 </table>
	</form>
</body>
</html>