<%@ page import="member.dao.MemberDAO"%>
<%@ page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정완료</title>
</head>
<body>
</body>
<script type="text/javascript">
window.onload=function(){
	alert("회원정보수정 성공");
	location.href="/mvcmember/member/loginForm.do";
}
</script>
</html>