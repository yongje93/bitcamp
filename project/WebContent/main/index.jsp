<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>메인화면</title>
<style type="text/css">
header .navigation {
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
	<section id="display">
		<jsp:include page="${display }"/>
		<%-- <jsp:include page="../template/body.jsp"/> --%>
	</section>
	<footer>
		<jsp:include page="../template/bottom.jsp"/>
	</footer>
</body>
</html>