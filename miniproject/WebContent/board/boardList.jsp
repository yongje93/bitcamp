<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${requestScope.boardList != null}">
	<table border="1" frame="hsides" rules="rows" cellspacing="0" cellpadding="5" style="word-break: break-all;">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="boardDTO" items="${boardList }">
			<tr>
				<td width="100" align="center">
				<c:if test="${boardDTO.pseq == 0 }">
					${boardDTO.seq}
				</c:if>
				</td>
				<td width="400">
				<c:forEach var="i" begin="1" end="${boardDTO.lev }" step="1">
					&emsp;
				</c:forEach> 
				<c:if test="${boardDTO.lev != 0 }">
					<img src="../image/reply.gif">
				</c:if> 
					<a href="javascript:void(0)" id="subjectA"
						onclick="isLogin(${boardDTO.seq },${pg })"> ${boardDTO.subject }
					</a>
				</td>
				<td width="120" align="center">${boardDTO.id}</td>
				<td width="150" align="center">${boardDTO.logtime}</td>
				<td width="80" align="center">${boardDTO.hit}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<br>
<div style="float: left; width: 850px; text-align: center;">
	${boardPaging.pagingHTML }
</div>
<br>
<br>
<div style="float: left; width: 850px; text-align: center;">
	<form name="searchFrom" method="post" action="/miniproject/board/boardSearch.do">
		<input type="hidden" name="pg" value="1">
		<select name="opt" id="opt" style="width: 80px;">
			<option value="subject">제목</option>
			<option value="id">작성자</option>
		</select> 
		<input type="text" name="condition" value="${condition }" style="width: 180px;" placeholder="검색어입력"> 
		<input type="submit" value="검색">
	</form>
</div>
<script type="text/javascript">
function isLogin(seq, pg){
	if("${memId}"=="")
		alert("먼저 로그인하세요");
	else
		location.href="/miniproject/board/boardView.do?seq="+seq+"&pg="+pg;		
}

window.onload=function(){
	if("${opt}"=="subject" || "${opt}"=="id")
		document.getElementById("opt").value = "${opt}";
}

function boardSearch(pg) {
	location.href="/miniproject/board/boardSearch.do?pg="+pg+"&opt=${opt}&condition="+encodeURIComponent("${condition}");
}
</script>
<link rel="stylesheet" href="../css/board.css">