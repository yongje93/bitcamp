<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" href="../css/board.css">
</head>
<body>
	<h1>게시판 목록</h1>
	<c:if test="${requestScope.boardList != null}">
 	 <table border="1" frame="hsides" rules="rows" cellspacing="0" cellpadding="5" style="word-break:break-all;">
	 	<tr>
	 		<th>글번호</th>
	 		<th>제목</th>
	 		<th>작성자</th>
	 		<th>작성일</th>
	 		<th>조회수</th>
	 	</tr>
	 	<c:forEach var="boardDTO" items="${boardList }">
	 		<tr>
	 	 		<td width="100" align="center">${boardDTO.seq}</td>
	 	 		<td width="400" align="left">
	 	 			<a href="javascript:void(0)" id="subjectA" 
						onclick="isLogin(${boardDTO.seq },${pg })">
						${boardDTO.subject }
				</a>
	 	 		</td>
	 	 		<td width="120" align="center">${boardDTO.id}</td>
	 	 		<td width="150" align="center">${boardDTO.logtime}</td>
	 	 		<td width="80" align="center">${boardDTO.hit}</td>	
 	 		</tr>
	 	</c:forEach>
	 </table>
  </c:if>
  <div style="float: left; width: 850px; text-align: center;">  	 
	 ${boardPaging.pagingHTML }
  </div>
</body>
<script type="text/javascript">
function isLogin(seq,pg){
	//if("${memId}"=="")
	//	alert("먼저 로그인하세요");
	//else
		location.href="/mvcboard/board/boardView.do?seq="+seq+"&pg="+pg;		
}
</script>
</html>