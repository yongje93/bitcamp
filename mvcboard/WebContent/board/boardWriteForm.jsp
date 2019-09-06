<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
</head>
<body>
	<h1>글쓰기</h1>
	<form name="boardWriteForm" method="post" action="/mvcboard/board/boardWrite.do">
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
	 		<td colspan="2" align="center">
	 			<input type="button" value="글쓰기" onclick="checkBoard()">
	 			<input type="reset" value="다시작성">
	 		</td>
	 	</tr>
	 </table>
	</form>
</body>
<script type="text/javascript" src="../js/board.js"></script>
</html>