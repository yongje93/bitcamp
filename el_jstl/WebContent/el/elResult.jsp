<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${param['x'] } + ${param['y'] } = ${param['x'] + param['y'] }<br>
	${param['x'] } - ${param['y'] } = ${param['x'] - param['y'] }<br>
	${param.x } * ${param.y } = ${param.x * param.y }<br>
	${param.x } / ${param.y } = ${param.x / param.y }<br>
</body>
</html>