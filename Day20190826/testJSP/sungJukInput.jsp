<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
	</head>
	<body>
		<form name="sungJukForm" method="get" action="sungJukResult.jsp">
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<th width="80">이름</th>
				<td><input type="text" name="name" placeholder="이름입력" size="15"></td>
			</tr>
			<tr>
				<th width="80">국어</th>
				<td><input type="text" name="korea" placeholder="국어점수 입력" size="15"></td>
			</tr>
			<tr>
				<th width="80">영어</th>
				<td><input type="text" name="english" placeholder="영어점수 입력" size="15"></td>
			</tr>
			<tr>
				<th width="80">수학</th>
				<td><input type="text" name="math" placeholder="수학점수 입력" size="15"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="계산">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
		</form>
	</body>
</html>
