<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "홍길동";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>** include directive **</h3>
<%@ include file="today.jsp" %>	<!-- today.jsp 파일을 가지고 온다. 가지고 와서 컴파일해서 변수명 겹치면 에러남 -->

<h3>** include JSP tag **</h3>
<jsp:include page="image.jsp" /> <!-- 컴파일 한 결과만 합침 -->

<br><br>
main.jsp name = <%=name %>

<h3>** 3초 뒤에 페이지 이동 **</h3>
<% response.setHeader("Refresh", "3;url=input.jsp"); %>
</body>
</html>