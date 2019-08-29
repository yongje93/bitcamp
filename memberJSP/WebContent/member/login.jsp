<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.dao.MemberDAO"%>
<%@ page import="java.net.URLEncoder"%>

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
<form name="loginForm" method="post" action="modifyForm.jsp">
	<input type="hidden" name="id" value="<%=id%>">
	<img src="../image/dog.png" width="50" height="50" onclick="location.href='../main/index.jsp'" style="cursor: pointer;">
	
	<% if(name != null) {
		//request.getSession().setAttribute("name", name);
		response.sendRedirect("loginOk.jsp?name=" + URLEncoder.encode(name, "UTF-8"));	// 주소창에 name을 인코딩,암호화해서 보내줌
 	} else {
		response.sendRedirect("loginFail.jsp");
	} %>
</form>
</body>
<script src="../js/member.js" type="text/javascript"></script>
</html>