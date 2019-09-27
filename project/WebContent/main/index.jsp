<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
<style type="text/css">
*{
	text-align: center;
}
header{
    /* border : 2px solid red; */
    line-height: 55px;
    height : 55px;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="../template/top.jsp"/>
	</header>
	<section>
		<jsp:include page="../template/body.jsp"/>
	</section>
	<footer>
		<jsp:include page="../template/bottom.jsp"/>
	</footer>
</body>
</html>