<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8" />

${id }는 사용 가능
<br><br>
<input type="button" value="사용하기" onclick="checkIdClose('${id }')">
<script src="../js/member.js" type="text/javascript"></script>
