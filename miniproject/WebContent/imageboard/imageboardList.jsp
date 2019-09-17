<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  
<c:if test="${requestScope.imageboardList != null}">
<table border="1" frame="hsides" rules="rows" cellspacing="0" cellpadding="5" style="word-break:break-all;">
	<tr>
		<th width="80">번호</th>
		<th width="120">이미지</th>
		<th width="120">상품명</th>
		<th width="80">단가</th>
		<th width="80">개수</th>
		<th width="80">합계</th>
	</tr>
	<c:forEach var="imageboardDTO" items="${imageboardList }">
	<tr>
		<td align="center">${imageboardDTO.seq }</td>
		<td align="center"> 
			<a class="onsubject" style="cursor: pointer;" href="javascript:void(0)" onclick="location.href='/miniproject/imageboard/imageboardView.do?seq=${imageboardDTO.seq}&pg=${pg}'">
				<img src="http://localhost:8080/miniproject/storage/${imageboardDTO.image1}" width="100" height="100">
			</a>
		</td>
		<td align="center">${imageboardDTO.imageName }</td>
		<td align="center">
			<fmt:formatNumber type="number" value="${imageboardDTO.imagePrice }" pattern="#,###"/>
		</td>
		<td align="center">${imageboardDTO.imageQty }</td>
		<td align="center">
			<fmt:formatNumber type="number" value="${imageboardDTO.imagePrice * imageboardDTO.imageQty }" pattern="#,###원"/>
		</td>
	</tr>
	</c:forEach>
</table>
</c:if>
<br>
<div style="float: left; width: 700px; text-align: center;">  	 
	${imageboardPaging.pagingHTML }
</div>
