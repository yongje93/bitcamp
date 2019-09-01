<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.dao.BoardDAO"%>
<%@ page import="board.bean.BoardDTO"%>
<%
	// 데이터
	request.setCharacterEncoding("UTF-8");

	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	int seq = Integer.parseInt(request.getParameter("seq"));
	
	BoardDTO boardDTO = new BoardDTO();
	boardDTO.setSeq(seq);
	boardDTO.setSubject(subject);
	boardDTO.setContent(content);
	
	//DB
	BoardDAO boardDAO = BoardDAO.getInstance();
	boardDAO.boardModify(boardDTO);

%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>

</body>
<script type="text/javascript">
window.onload=function() {
	alert("글수정 성공");
	location.href="../main/index.jsp";
}
</script>
</html>