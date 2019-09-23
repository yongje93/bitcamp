<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8" />
<c:set var="birthday" value="${fn:split(param.birthday,'/')}" />
<c:set var="year" value="${birthday[0] }"/>
<c:set var="month" value="${birthday[1] }"/>
<c:set var="day" value="${birthday[2] }"/>

<c:set var="now" value="<%=new java.util.Date()%>" />
<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set> 

<jsp:useBean id="now" class="java.util.Date"/>
<fmt:formatDate value="today" value="${now }" pattern="yyyy" />

${param.name}님의 생일은 ${year}년 ${month}월  ${day}일 입니다.
나이는 ${sysYear-year+1}살 입니다.