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
	
	String id = (String) session.getAttribute("memId");
	 
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
	
	#subjectA:link {color: black; text-decoration: none;} 
	#subjectA:visited {color: black; text-decoration: none;} 
	#subjectA:hover {color: green; text-decoration: underline;}
	#subjectA:active {color: black; text-decoration: none;}
</style>
</head>
<body>
	<h1>게시판 목록</h1>
	 <table border="1" frame="hsides" rules="rows" cellspacing="0" cellpadding="5" style="word-break:break-all;">
	 	<tr>
	 		<th>글번호</th>
	 		<th>제목</th>
	 		<th>작성자</th>
	 		<th>작성일</th>
	 		<th>조회수</th>
	 	</tr>
 	 <% if(boardList != null) {
	 	 for(BoardDTO boardDTO : boardList) { %>
 	 		<tr>
	 	 		<td width="100" align="center"><%=boardDTO.getSeq() %></td>
	 	 		<td width="400" align="left">
	 	 			<a id="subjectA" href='javascript:void(0);' onclick="isLogin('<%=id%>','<%=boardDTO.getSeq() %>');">
	 	 				<%=boardDTO.getSubject() %>
	 	 			</a>
	 	 		</td>
	 	 		<td width="120" align="center"><%=boardDTO.getId() %></td>
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
  <br>
  <img src="../image/dog.png" width="100" height="100" onclick="location.href='../main/index.jsp'" style="cursor: pointer;">
</body>
<script type="text/javascript" src="../js/board.js"></script>
</html>