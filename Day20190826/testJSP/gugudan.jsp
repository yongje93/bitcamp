<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<body>
	<h1>구구단</h1>
		<table border="1" cellspacing="0" cellpadding="5">
		<%	for(int i=1; i<=9; i++){	%>
			<tr>
			<%	for(int dan=2; dan<=9; dan++) {	%>
				<td align="left"><%= dan%> * <%=i%> = <%=dan*i%> </td>
			<%}//for dan%>
			</tr> 
		<%}//for i%>
		</table>
	</body>
</html>