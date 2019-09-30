<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>쇼핑몰</title>
<style type="text/css">
@import url('https://cdn.rawgit.com/innks/NanumSquareRound/master/nanumsquareround.min.css');

body {
 	color: #333; 
 	font-family: 'NanumSquareRound', "Apple SD Gothic Neo", "Nanum Gothic", 'Lato', Helvetica, sans-serif, "Noto Sans KR" ,"Malgun Gothic", "맑은 고딕", Dotum, '돋움' ; 
}

</style>
<link rel="stylesheet" type="text/css" href="../css/top.css">
<link rel="stylesheet" type="text/css" href="../css/body.css">
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