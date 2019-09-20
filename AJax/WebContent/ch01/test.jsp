<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:requestEncoding value="UTF-8"/>

<c:set var="birthday" value="${fn:split(param.birthday,'/')}" />
<c:set var="now" value="<%=new java.util.Date()%>" />
<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set> 

<fmt:parseNumber var="bornYear" type="number" value="${birthday[0]}"/>
<fmt:parseNumber var="nowYear" type="number" value="${sysYear }"/>
${param.name}님의 생일은 ${birthday[0]}년 ${birthday[1]}월  ${birthday[2]}일 입니다
나이는 ${nowYear-bornYear+1}살 입니다