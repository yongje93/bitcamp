<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO"%>
<%@ page import="board.dao.BoardDAO"%>

<%
	// 세션
	String id = (String) session.getAttribute("memId");
	
	// 데이터
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	// DB
	BoardDAO boardDAO = BoardDAO.getInstance();
	// 조회수 1증가
	//boardDAO.boardHit(seq);
	
	boolean isGet = false;
	Cookie[] ar = request.getCookies();
	if(ar != null) {
		for(Cookie c: ar) {
			if(c.getValue().equals("pg="+pg)) {
				isGet = true;
			}
		}
		if(!isGet) {
			boardDAO.boardHit(seq);		
			Cookie cookie = new Cookie("cookie","pg="+pg);
			cookie.setMaxAge(1*24*60*60);
			response.addCookie(cookie);
		}
	}
	
	// 게시글 가져오기
	BoardDTO boardDTO = boardDAO.getBoard(seq);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<style>
	#subject { font-size: 20px; font-weight: bold;}
	pre { overflow: auto; width: 100%; height: 150px; white-space: pre-line; word-break: break-all; }
</style>
</head>
<body>
	<h1>게시글 보기</h1>
	<%if(boardDTO!=null) { %>
	<table border="1" width="450" frame="hsides" rules="rows" cellspacing="0" cellpadding="5">
		<tr>
			<td id="subject" colspan="5"><%=boardDTO.getSubject() %></td>
		</tr>
		<tr>	
			<td width="150">글번호 : <%=boardDTO.getSeq() %></td>
			<td width="30"></td>
			<td width="150">작성자 : <%=boardDTO.getId() %></td>
			<td width="30"></td>
			<td width="90">조회수 : <%=boardDTO.getHit() %></td>
		</tr>
		<tr>
			<td id="content" colspan="5" valign="top">
			<pre><%=boardDTO.getContent() %></pre>
			</td>
		</tr>
		<tr>
	</table>
	<br>
	<input type="button" value="목록" onclick="location.href='boardList.jsp?pg=<%=pg%>'">
		<% if(id.equals(boardDTO.getId())) { %>
		<input type="button" value="글수정" onclick="location.href='boardModifyForm.jsp?seq=<%=boardDTO.getSeq()%>&pg=<%=pg%>'">
		<input type="button" value="글삭제" onclick="checkBoardDelete('<%=boardDTO.getSeq()%>')">
		<% } %>
	<% } %>
</body>
<script type="text/javascript" src="../js/board.js"></script>
</html>