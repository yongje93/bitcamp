<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String name = null;
	String id = null;
	
	//쿠키
	/*
	Cookie[] ar = request.getCookies(); //특정 쿠키를 얻지 못하고 모든 쿠키를 가쟈온다.
	if(ar != null) {
		for(int i=0; i<ar.length; i++) {
			//String cookieName = ar[i].getName(); // 쿠키명
			//String cookieValue = ar[i].getValue(); //값
			//System.out.println(cookieName+", "+cookieValue);
			
			if("memName".equals(ar[i].getName())) {	name = ar[i].getValue(); }
			if("memId".equals(ar[i].getName())) { id = ar[i].getValue(); }
		}
	}
	*/
	
	//세션
	name = (String) session.getAttribute("memName");
	id = (String) session.getAttribute("memId");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img src="../image/dog.png" width="50" height="50" onclick="location.href='../main/index.jsp'" style="cursor: pointer;">
	<%=name %>님 로그인
	<br><br>
	<input type="button" value="로그아웃" onclick="location.href='logout.jsp'">
	<input type="submit" value="회원정보수정" onclick="location.href='modifyForm.jsp'">
</body>
</html>