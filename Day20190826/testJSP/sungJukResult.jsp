<%@ page contentType="text/html;charset=UTF-8" %>

<%-- 데이터 --%>
<%	
String name = request.getParameter("name");
int korea = Integer.parseInt(request.getParameter("korea"));
int english = Integer.parseInt(request.getParameter("english"));
int math = Integer.parseInt(request.getParameter("math")); 
int total = korea + english + math;
double avg = total/3.0;
%>
<html>
	<head>
	</head>
	<body>
	<%-- 응답 --%>
	<h2>*** <%=name%> 성적표 ***</h2>
	<table border="1" cellspacing="0" cellpadding="5">
		<tr>
			<th width="70">국어</th>
			<th width="70">영어</th>
			<th width="70">수학</th>
		</tr>
		<tr>
			<td align="center"><%=korea%></td>
			<td align="center"><%=english%></td>
			<td align="center"><%=math%></td>
		</tr>
		<tr>
			<td colspan="3">총점 = <%=total%>
		</tr>
		<tr>
			<td colspan="3">평균 = <%=String.format("%.3f", avg)%>
		</tr>
	</table>
	</body>
</html>