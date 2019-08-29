<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.dao.BoardDAO"%>

<%
request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="boardDTO" class="board.bean.BoardDTO"/>    
<jsp:setProperty property="*" name="boardDTO"/>

<%
	//DB
	BoardDAO boardDAO = BoardDAO.getInstance();
	int su = boardDAO.boardWrite(boardDTO);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 응답 --%>
	<% if(su == 1) { %>
		글쓰기 성공
	<% } else {%>
		글쓰기 실패
	<% } %>
</body>
</html>