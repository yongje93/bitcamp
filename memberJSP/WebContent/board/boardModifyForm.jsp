<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO"%>

<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>

<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	BoardDTO boardDTO = boardDAO.getBoard(seq);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<h1>게시글 수정</h1>
	<form name="boardModifyForm" method="post" action="boardModify.jsp">
	<input type="hidden" name="seq" value="<%=seq %>">
	<input type="hidden" name="pg" value="<%=pg %>">
	<table border="1" cellspacing="0" cellpadding="5">
	 	<tr>
	 		<td width="80" align="center">제목</td>
	 		<td width="200">
	 			<input type="text" name="subject" style="width: 250px;" value="<%=boardDTO.getSubject() %>">
	 		</td>
	 	</tr>
	 	<tr>
	 		<td width="80" align="center">내용</td>
	 		<td>
	 		 <textarea name="content" cols="40" rows="10" style="resize: none"><%=boardDTO.getContent() %></textarea>
	 		</td>
	 	</tr>
	 	<tr>
	 		<td colspan="2" align="center">
	 			<input type="button" value="글수정" onclick="checkBoardModify()">&nbsp;&nbsp;
	 			<input type="reset" value="다시작성">
	 		</td>
	 	</tr>
	 </table>
	</form>
</body>
<script type="text/javascript" src="../js/board.js"></script>
</html>