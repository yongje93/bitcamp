<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="section-title">
	<h3>${memberDTO.name }님 안녕하세요!</h3>
	<div class="account-menu">
		<a data-toggle="modal" href="#passwordModal">회원정보수정</a> 
		<a href="/project/member/logout.do">로그아웃</a>
	</div>
</div>
<div class="section">
	<div class="account-summary">
		<div class="item">
			<div class="label">
				<a href="">적립금 <i class="fa fa-chevron-right"></i></a>
			</div>
			<div class="value">
				<fmt:formatNumber pattern="#,###원" value="${memberDTO.savedmoney}" />
			</div>
		</div>
		<div class="item">
			<div class="label">
				<a href="">누적주문금액 <i class="fa fa-chevron-right"></i></a>
			</div>
			<div class="value">###원 채워야됨</div>
		</div>
	</div>
</div>
<div class="section-title">
	<h3>최근 주문</h3>
	<div class="section page-list order-list">
		<div class="empty-list">주문내역이 없습니다.</div>
	</div>
</div>
