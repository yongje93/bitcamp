<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.dao.BoardDAO"%>
<%@ page import="board.bean.BoardDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	// 데이터
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	int endNum = pg*5;
	int startNum = endNum - 4;
	
	BoardDAO boardDAO = BoardDAO.getInstance();
	List<BoardDTO> boardList = boardDAO.boardList(startNum, endNum);
	
	int totalBoard = boardDAO.getTotalBoard();
	int totalPage = (totalBoard+4)/5;
	
	SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<style>
	th { style="word-break:break-all"}
	#currentPaging { color: red; text-decoration: underline; }
	#paging { color: black; text-decoration: none; }
</style>
</head>
<body>
	<h1>게시판 목록</h1>
	 <table border="1" cellspacing="0" cellpadding="5" width="100%" style="table-layout:fixed; word-break:break-all;">
	 	<tr>
	 		<th width="100">글번호</th>
	 		<th width="400">제목</th>
	 		<th width="120">작성자</th>
	 		<th width="150">작성일</th>
	 		<th width="80">조회수</th>
	 	</tr>
 	 <% if(boardList != null) {
	 	 for(BoardDTO boardDTO : boardList) { %>
 	 		<tr>
	 	 		<td width="100" align="center"><%=boardDTO.getSeq() %></td>
	 	 		<td width="400" align="left"><%=boardDTO.getSubject() %></td>
	 	 		<td width="120" align="left"><%=boardDTO.getId() %></td>
	 	 		<td width="150" align="center"><%=date.format(boardDTO.getLogtime()) %></td>
	 	 		<td width="80" align="center"><%=boardDTO.getHit() %></td>	
 	 		</tr>
	 	<% } %>
	 </table>
	 <br><br>
	 <%for(int i = 1; i <= totalPage; i++) {
			if(i == pg) {%> 
				<a id="currentPaging" href="boardList.jsp?pg=<%=i%>">[<%=i %>]</a>
	 	<% } else { %>
	 			<a id="Paging" href="boardList.jsp?pg=<%=i%>">[<%=i %>]</a>
	 	<% }
	 } 
  } %>
</body>
</html>