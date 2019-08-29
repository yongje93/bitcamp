<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="dataDTO" class="exam.bean.DataDTO" scope="session"/>	<!-- useBean은 싱글톤. default 기본생성자만 부름. 쓰지마. scope는 유효범위 -->
<jsp:setProperty property="x" name="dataDTO"/>	<!-- dataDTO랑 변수명 같게 해줘야됨.  -->
<jsp:setProperty property="y" name="dataDTO"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>합</title>
</head>
<body>
	<form name="sumForm" method="get" action="mul.jsp">
	 <table border="1" cellspacing="0" cellpadding="3">
		<tr>
			<td width="150">
				<jsp:getProperty property="x" name="dataDTO"/> + 
				<jsp:getProperty property="y" name="dataDTO"/> = 
				<%=dataDTO.getX() + dataDTO.getY() %>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="곱구하기">
				<input type="button" value="곱구하기" onclick="location.href='mul.jsp'">
			</td>
		</tr>
	 </table>
	</form>
</body>
</html>