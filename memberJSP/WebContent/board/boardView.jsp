<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<style>
	#title { font-size: 20px; font-weight: bold;}
</style>
</head>
<body>
	<h1>게시글 보기</h1>
	<table border="1" frame="hsides" rules="rows" cellspacing="0" cellpadding="5">
		<tr>
			<td id="title" colspan="5">
			제목
			</td>
		</tr>
		<tr>	
			<td width="100">글번호 :  </td>
			<td width="100"></td>
			<td width="100">작성자 :	</td>
			<td width="100"></td>
			<td width="100">조회수 :	</td>
		</tr>
		<tr>
			<td id="content">
			내용
			</td>
		</tr>
		<tr>
			<td colspan="5">
				<img src="../image/dog.png" width="30" height="30" onclick="location.href='../main/index.jsp'" style="cursor: pointer;">
				<input type="button" value="글수정" onclick="">
				<input type="button" value="글삭제" onclick="">
			</td>
		</tr>
	</table>
</body>
</html>