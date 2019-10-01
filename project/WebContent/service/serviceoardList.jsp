<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${serviceboardList != null}">
<div class="section-title">
	<h3>고객센터</h3>
	<div class="service-menu">
		<a href="#">문의하기</a>
	</div>
</div>
<div class="section">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			<tr>
		</thead>
		<tbody>
			<tr>
			
			<tr>
		</tbody>
	</table>
</div>	

</c:if>
    