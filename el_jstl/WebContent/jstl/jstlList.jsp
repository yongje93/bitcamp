<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sql:query var="rs" dataSource="jdbc/oracle">
	select * from usertable
</sql:query>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellspacing="0" cellpadding="5">
		<!-- 필드명 -->
		<tr>
		<c:forEach var="colName" items="${rs.columnNames }"> <!--  columnNames는 앞에 접두사 get을 뺀 함수이다 -->
			<th>${colName }</th>
		</c:forEach>
		<th>비고</th>
		</tr>
		<!-- 필드 -->
		<c:forEach var="row" items="${rs.rowsByIndex }"> <!-- 행  | rowsByIndex는 앞에 접두사 get을 뺀 함수이다.-->
		<tr>
			<c:forEach var="col" items="${row }" varStatus="status">	<!-- 열 -->
				<td width="100" align="center">${col }</td> 
			</c:forEach>
			<td width="150" align="center">
				<input type="button" value="수정" onclick="location.href='jstlModifyForm.jsp?id=${row[1] }'">
				<input type="button" value="삭제" onclick="location.href='jstlDelete.jsp?id=${row[1] }'">
			</td>
		</tr>
		</c:forEach>
	</table>
	<br><br>
	<input type="button" value="처음" onclick="location.href='jstlForm.jsp'">
</body>
</html>