<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="dataDTO" class="exam.bean.DataDTO" scope="session"/> <!-- 싱글톤이라 한번만 잡힘 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>곱</title>
</head>
<body>
	<form name="mulForm" method="get" action="mul.jsp">
	 <table border="1" cellspacing="0" cellpadding="3">
		<tr>
			<td width="150">
			<jsp:getProperty property="x" name="dataDTO"/> * 
			<jsp:getProperty property="y" name="dataDTO"/> = 
			<%=dataDTO.getX() * dataDTO.getY() %></td>
		</tr>
	 </table>
	</form>
</body>
</html>