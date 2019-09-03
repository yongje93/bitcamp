<%@ page import="board.bean.BoardPaging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.dao.BoardDAO"%>
<%@ page import="board.bean.BoardDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	// 세션
	String memId = "";
	if((String)session.getAttribute("memId") != null) {
		memId = (String) session.getAttribute("memId");
	}
	// 데이터
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	// DB - 1페이지당 5개씩
	int endNum = pg*5;
	int startNum = endNum - 4;
	BoardDAO boardDAO = BoardDAO.getInstance();
	List<BoardDTO> boardList = boardDAO.boardList(startNum, endNum);
	
	SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd");

	// 페이징 처리
	BoardPaging boardPaging = new BoardPaging();
	int totalA = boardDAO.getTotalA();// 총글수
	boardPaging.setCurrentPage(pg);
	boardPaging.setPageBlock(3);
	boardPaging.setPageSize(5);
	boardPaging.setTotalA(totalA);
	boardPaging.makePagingHTML();
	
	// 조회수 - 새로고침 방지
	if(session.getAttribute("memId") != null) {
		Cookie cookie = new Cookie("memhit", "0");
		cookie.setMaxAge(30*60);
		response.addCookie(cookie); //클라이언트에게 보내기
	}
	/*
	// 조회수(내가한거)
	Cookie[] ar = request.getCookies();
	if(ar != null) {
		for(int i=0; i<ar.length; i++) {
			if("cookie".equals(ar[i].getName())) {
				ar[i].setMaxAge(0); // 쿠키삭제
				response.addCookie(ar[i]); // 클라이언트에 저장
			}
		}
	}
	*/
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" href="../css/board.css">
</head>
<body>
	<h1>게시판 목록</h1>
 	 <% if(boardList != null) { %>
	 <table border="1" frame="hsides" rules="rows" cellspacing="0" cellpadding="5" style="word-break:break-all;">
	 	<tr>
	 		<th>글번호</th>
	 		<th>제목</th>
	 		<th>작성자</th>
	 		<th>작성일</th>
	 		<th>조회수</th>
	 	</tr>
	 	<% for(BoardDTO boardDTO : boardList) { %>
 	 		<tr>
	 	 		<td width="100" align="center"><%=boardDTO.getSeq() %></td>
	 	 		<td width="400" align="left">
	 	 			<a id="subjectA" href='javascript:void(0);' onclick="isLogin('<%=memId%>',<%=boardDTO.getSeq() %>,<%=pg%>);">
	 	 				<%=boardDTO.getSubject() %>
	 	 			</a>
	 	 		</td>
	 	 		<td width="120" align="center"><%=boardDTO.getId() %></td>
	 	 		<td width="150" align="center"><%=date.format(boardDTO.getLogtime()) %></td>
	 	 		<td width="80" align="center"><%=boardDTO.getHit() %></td>	
 	 		</tr>
	 	<% } %>
	 </table>
  <% } %>
  <div style="width: 50px; float: left;">
  	<img src="../image/dog.png" width="50" height="50" onclick="location.href='../main/index.jsp'" style="cursor: pointer;">
  </div>
  <div style="float: left; width: 850px; text-align: center;">  	 
	 <%=boardPaging.getPagingHTML() %>
  </div>
</body>
<script type="text/javascript" src="../js/board.js"></script>
</html>