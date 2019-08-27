<%@ page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	// DB
	MemberDAO memberDAO = MemberDAO.getInstance();
	String name = memberDAO.login(id, pwd);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
	<!-- 응답 -->
	<% response.setContentType("text/html;charset=UTF-8"); %>
	<% if(name != null) { %>
		<%=name %>님 로그인
		<br><br>
		<input type="button" value="로그아웃" onclick="">
		<input type="button" value="회원정보수정" onclick="location.href='modifyForm.jsp?id=<%=id%>'">
	<% } else { %>
		아이디 또는 비밀번호가 맞지 않습니다
	<% } %>
</body>
<script src="../js/member.js" type="text/javascript"></script>
</html>