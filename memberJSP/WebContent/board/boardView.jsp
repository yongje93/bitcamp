<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO"%>
<%@ page import="board.dao.BoardDAO"%>

<%
	// 세션
	String memId = (String) session.getAttribute("memId");

	// 데이터
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	// DB
	BoardDAO boardDAO = BoardDAO.getInstance();
	
	/*
	// 조회수(내가한거)
	boolean isGet = false;
	Cookie[] ar = request.getCookies(); // 모든 쿠키 얻어오기
	if(ar != null) {
		for(Cookie c: ar) {
			if(c.getValue().equals("pg="+pg)) {
				isGet = true;
			}
		}
		if(!isGet) {
			boardDAO.boardHit(seq); // 조회수 증가
			Cookie cookie = new Cookie("cookie","pg="+pg);
			cookie.setMaxAge(1*24*60*60);
			response.addCookie(cookie);
		}
	}
	*/
	// 조회수 -- 새로고침 방지
	Cookie[] ar = request.getCookies();
	if(ar != null) {
		for(int i=0; i<ar.length; i++) {
			if("memhit".equals(ar[i].getName())) {
				boardDAO.boardHit(seq); // 조회수 증가
				
				ar[i].setMaxAge(0); // 쿠키삭제
				response.addCookie(ar[i]); // 클라이언트에 저장
			}
		}
	}
	
	
	// 조회수 -- 쿠키시간 30분 사용
	/*
	boolean sw = false;
	
	Cookie[] ar = request.getCookies(); // 모든 쿠키 얻어오기
	if(ar != null) {
		for(int i=0; i<ar.length; i++) {
			if(ar[i].getName().equals(memId+seq)) {	// 사용자별 각자의 쿠키
				sw = true;			
			}
		}//for
		
		if(!sw) { // 쿠키가 없다는것
			boardDAO.boardHit(seq); // 조회수 증가
		
			Cookie cookie = new Cookie(memId+seq, seq+"");	// 쿠키이름, 값
			//System.out.println("쿠키명="+(memId+seq)+", 값="+seq+"");
			cookie.setMaxAge(30*60); // 30분
			response.addCookie(cookie); // 클라이언트에 보내기
		}
	}
	*/
	// 게시글 가져오기
	BoardDTO boardDTO = boardDAO.getBoard(seq);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<style>
	#subject { font-size: 25px; font-weight: bold;}
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
		<% if(memId.equals(boardDTO.getId())) { %>
		<input type="button" value="글수정" onclick="location.href='boardModifyForm.jsp?seq=<%=boardDTO.getSeq()%>&pg=<%=pg%>'">
		<input type="button" value="글삭제" onclick="checkBoardDelete('<%=boardDTO.getSeq()%>')">
		<% } %>
	<% } %>
</body>
<script type="text/javascript" src="../js/board.js"></script>
</html>