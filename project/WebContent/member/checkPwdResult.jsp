<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${checkPwdResult == 'ok'}">
	{ "result" : "ok"  }
</c:if>
<c:if test="${checkPwdResult == 'fail'}">
	{ "result" : "fail" }
</c:if>