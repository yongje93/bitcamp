<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${imageboardDTO != null }">
<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<td rowspan="4">
			<img src="http://localhost:8080/miniproject/storage/${imageboardDTO.image1}" width="200" height="200">
		</td>
		<td width="80" align="center">상품명</td>
		<td width="80" align="center">${imageboardDTO.imageName }</td>
	</tr>
	<tr>
		<td align="center">단가</td>
		<td align="center"><fmt:formatNumber type="number" value="${imageboardDTO.imagePrice }" pattern="#,###"/></td>
	</tr>
	<tr>
		<td align="center">개수</td>
		<td align="center">${imageboardDTO.imageQty }</td>
	</tr>
	<tr>
		<td align="center">합계</td>
		<td align="center"><fmt:formatNumber type="number" value="${imageboardDTO.imagePrice * imageboardDTO.imageQty }" pattern="#,###원"/></td>
	</tr>
	<tr>
		<td colspan="3" align="center">
			<textarea id="imageContent" name="imageContent" cols="50" rows="15" readonly="readonly" style="resize: none">${imageboardDTO.imageContent }</textarea>
		</td>
	</tr>
	<tr>
		<td colspan="3">
			<input type="button" value="목록" onclick="location.href='/miniproject/imageboard/imageboardList.do?pg=${pg}'">
		</td>
	</tr>
</table>
</c:if>