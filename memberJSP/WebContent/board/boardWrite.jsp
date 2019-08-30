<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.dao.BoardDAO"%>
<%@ page import="board.bean.BoardDTO"%>

<%
	// 데이터
	request.setCharacterEncoding("UTF-8");

	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	String id = (String) session.getAttribute("memId");
	String name = (String) session.getAttribute("memName");
	String email = (String) session.getAttribute("memEmail");
	
	BoardDTO boardDTO = new BoardDTO();
	boardDTO.setId(id);
	boardDTO.setName(name);
	boardDTO.setEmail(email);
	boardDTO.setSubject(subject);
	boardDTO.setContent(content);
	
	//DB
	BoardDAO boardDAO = BoardDAO.getInstance();
	boardDAO.boardWrite(boardDTO);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
<script type="text/javascript">
window.onload=function() {
	alert("글쓰기 성공");
}
</script>
</html>