<%@ page contentType="text/html;charset=UTF-8" %>	<!-- 현재 페이지에 대한 한글처리 -->
<%!
// 전역변수, init()
String name="홍길동";
int age=25;
%>
<%
//지역변수, service()
age++;
%>

<html>
<body>
<!--Hello JSP!!<br>-->				<!-- 웹에는 가지만 안보임 -->
<%-- 안녕하세요 JSP!!<br> --%>			<%-- 웹에 가지도 않음 --%>

나의 이름은 <%=name%> 입니다<br>

<!-- 내 나이는 <%=age%>살 입니다<br> -->
<%-- <% out.println("내 나이는 " + age + "살 입니다"); %> --%>
</body>
</html>