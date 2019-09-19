<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  
<table border="1" frame="hsides" rules="rows" cellspacing="0" cellpadding="5" style="word-break:break-all;">
	<tr>
		<th width="80"><input type="checkbox" name="checkAll" id="checkAll" onclick="checkAll()">번호</th>
		<th width="120">이미지</th>
		<th width="120">상품명</th>
		<th width="80">단가</th>
		<th width="80">개수</th>
		<th width="80">합계</th>
	</tr>
	<c:if test="${requestScope.imageboardList != null}">
		<c:forEach var="imageboardDTO" items="${imageboardList}">
		<tr>
			<td align="center"><input type="checkbox" name="checkRow" value="${imageboardDTO.seq}">${imageboardDTO.seq}</td>
			<td align="center"> 
				<a class="onsubject" style="cursor: pointer;" href="javascript:void(0)" onclick="location.href='/miniproject/imageboard/imageboardView.do?seq=${imageboardDTO.seq}&pg=${pg}'">
					<img src="http://localhost:8080/miniproject/storage/${imageboardDTO.image1}" width="100" height="100">
				</a>
			</td>
			<td align="center">${imageboardDTO.imageName}</td>
			<td align="center">
				<fmt:formatNumber pattern="#,###원" value="${imageboardDTO.imagePrice}"/>
			</td>
			<td align="center">
				<fmt:formatNumber pattern="#,###개" value="${imageboardDTO.imageQty}"/>
			</td>
			<td align="center">
				<fmt:formatNumber pattern="#,###원" value="${imageboardDTO.imagePrice * imageboardDTO.imageQty}"/>
			</td>
		</tr>
		</c:forEach>
	</c:if>
</table>
<c:if test="${memId == 'admin'}">
	<br>
	<input type="button" value="선택삭제" onclick="checkDelete()">
</c:if>
<br>
<div style="float: left; width: 700px; text-align: center;">  	 
	${imageboardPaging.pagingHTML}
</div>

<script type="text/javascript">
function checkAll() {
	var chkObj = document.getElementsByName("checkRow");
	var rowCnt = chkObj.length - 1;
	for(var i = 0; i <= rowCnt; i++) {		
		if(document.getElementById("checkAll").checked) {
			chkObj[i].checked = true;
		} else
			chkObj[i].checked = false;
	}
}

function checkDelete() {
	var chkObj = document.getElementsByName("checkRow");
	var rowCnt = chkObj.length - 1;
	var chkDelete = false;
	var chkSeq = new Array();
	for(var i = 0; i <= rowCnt; i++) {
		if(chkObj[i].checked) {
			chkDelete = true;
			chkSeq[i] = chkObj[i].value;
		}
	}
	if(!chkDelete) {
		alert("항목을 선택하세요");
	} else {
		if(confirm("정말 삭제하시겠습니까?") == true) {
			location.href="/miniproject/imageboard/imageboardDelete.do?seq="+chkSeq;
		}	
	}
}
</script>
<link rel="stylesheet" href="../css/board.css">