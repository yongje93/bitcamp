<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.dao.BoardDAO"%>
<%@ page import="board.bean.BoardDTO"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>

<%
	// 데이터
	request.setCharacterEncoding("UTF-8");

	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	//DB
	Map<String, String> map = new HashMap<String, String>();
	map.put("seq", seq+"");
	map.put("subject", subject);
	map.put("content", content);
	
	BoardDAO boardDAO = BoardDAO.getInstance();
	boardDAO.boardModify(map);

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
	location.href="boardList.jsp?pg=<%=pg%>";
}
</script>
</html>