<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO"%>
<%@ page import="board.dao.BoardDAO"%>

<% 
	String id = (String) session.getAttribute("memId");
	int seq = Integer.parseInt(request.getParameter("seq"));
	
	BoardDAO boardDAO = BoardDAO.getInstance();
	// 조회수 1증가
	boardDAO.updateHit(seq);
	// 게시글 가져오기
	BoardDTO boardDTO = boardDAO.getBoard(seq);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<style>
	#title { font-size: 20px; font-weight: bold;}
	pre { overflow: auto; width: 100%; height: 150px; white-space: pre-line; word-break: break-all; }
</style>
</head>
<body>
	<h1>게시글 보기</h1>
	<table border="1" frame="hsides" rules="rows" cellspacing="0" cellpadding="5">
		<tr>
			<td id="title" colspan="5">
			<%=boardDTO.getSubject() %>
			</td>
		</tr>
		<tr>	
			<td width="150">글번호 : <%=boardDTO.getSeq() %></td>
			<td width="30"></td>
			<td width="150">작성자 : <%=boardDTO.getId() %></td>
			<td width="30"></td>
			<td width="100">조회수 : <%=boardDTO.getHit() %></td>
		</tr>
		<tr>
			<td id="content" colspan="5" height="40">
			<pre><%=boardDTO.getContent() %></pre>
			</td>
		</tr>
		<tr>
			<td colspan="5">
				<img src="../image/dog.png" width="50" height="50" onclick="location.href='../main/index.jsp'" style="cursor: pointer;">
				<% if(id.equals(boardDTO.getId())) { %>
				<input type="hidden" name="seq" value="<%=boardDTO.getSeq()%>">
				<input type="button" value="글수정" onclick="location.href='boardModifyForm.jsp?seq=<%=boardDTO.getSeq()%>'">
				<input type="button" value="글삭제" onclick="checkBoardDelete('<%=boardDTO.getSeq()%>')">
				<% } %>
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript" src="../js/board.js"></script>
</html>