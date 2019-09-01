<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>
    
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	boardDAO.boardDelete(seq);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 삭제</title>
</head>
<body>
</body>
<script type="text/javascript">
window.onload=function() {
	alert("글삭제 성공");
	location.href="boardList.jsp?pg=1";
}
</script>
</html>