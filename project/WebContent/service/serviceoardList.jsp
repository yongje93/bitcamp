<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${serviceboardList != null}">
<div class="section-title">
	<h3>고객센터</h3>
	<div class="service-menu">
		<button type="button" class="btn btn-secondary" onclick="location.href='/project/service/serviceBoardWriteForm.do'">문의하기</button>
	</div>
</div>
<div class="section">
	<div class="serviceTable">
		<table class="table table-hover">
			<thead class="thead-light">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				<tr>
			</thead>
			<tbody>
			<c:forEach var="serviceboardDTO" items="${serviceboardList }">
				<tr onclick="location.href='/project/service/serviceBoardView.do?seq=${serviceboardDTO.seq}&pg=${pg}'" style="cursor: pointer;">
					<td style="width: 10%; text-align: center;">
						<c:if test="${serviceboardDTO.pseq == 0 }">
							${serviceboardDTO.seq}
						</c:if>
					</td>
					<td style="width: 40%">${serviceboardDTO.subject}</td>
					<td style="width: 20%; text-align: center;">${serviceboardDTO.name}</td>
					<td style="width: 20%; text-align: center;">${serviceboardDTO.logtime}</td>
					<td style="width: 10%; text-align: center;">${serviceboardDTO.hit}</td>
				<tr>
			</c:forEach>
			</tbody>
		</table>
		<div id="pagingDiv">
			${boardPaging.pagingHTML}
		</div>
	</div>
</div>
</c:if>
    