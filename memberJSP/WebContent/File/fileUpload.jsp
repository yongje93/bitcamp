<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>

<%
	//실제폴더
	String realFolder = request.getServletContext().getRealPath("/storage");
	System.out.println("실제폴더= " + realFolder);
	
	//업로드
	MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());//5MB, 파일중복되면 1,2,3 이 붙음
	
	String subject = multi.getParameter("subject");
	String content = multi.getParameter("content");
	
	String originalaFilName1 = multi.getOriginalFileName("upload1");
	String originalaFilName2 = multi.getOriginalFileName("upload2");
	
	String fileName1 = multi.getFilesystemName("upload1");
	String fileName2 = multi.getFilesystemName("upload2");
	
	File file1 = multi.getFile("upload1");
	File file2 = multi.getFile("upload2");
	
	long fileSize1 = 0;
	long fileSize2 = 0;
	if(file1 != null) fileSize1 = file1.length(); // 파일의 크기를 구할때 length() 사용
	if(file2 != null) fileSize2 = file2.length();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 완료</title>
</head>
<body>
<h3>업로드 완료</h3>
<ul>
	<li>제 목 : <%=subject %> <br>
	<li>내 용 : <pre><%=content %></pre><br>
	<li>파 일 : <a href="fileDownload.jsp?fileName=<%=URLEncoder.encode(originalaFilName1, "UTF-8") %>"><%=originalaFilName1 %></a><br> <!-- 다운로드 a태그 -->
	<li>파 일 : <%=fileName1 %><br>
	<li>크 기 : <%=fileSize1 %> byte<br>
	--------------------------
	<li>파 일 : <%=originalaFilName2 %><br>
	<li>파 일 : <%=fileName2 %><br>
	<li>크 기 : <%=fileSize2 %> byte<br>
</ul>
</body>
</html>