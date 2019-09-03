<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.io.BufferedOutputStream"%>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.BufferedInputStream"%>
    
<%
	String fileName = request.getParameter("fileName");
	String realFolder = request.getServletContext().getRealPath("/storage");
	System.out.println(realFolder+"\\"+fileName);
	
	//다운로드 받을 파일 생성
	File file = new File(realFolder, fileName);
	fileName = URLEncoder.encode(fileName, "UTF-8").replace("+"," "); // 한글은 공백부분에  +가 들어오는데 이걸 공백으로 바꿔줘라
	
	response.setHeader("Content-Disposition", "attachment;fileName="+fileName);
	response.setHeader("Content-Length", file.length()+"");
	
	/*
	getOutputStream() has already been called for this response
	JSP에서는 SERVLET으로 변환될 때 내부적으로 out객체가 자동으로 생성하기 때문에 out객체를 만들면 충돌이 일어나서 저런 메세지가 뜬다.
	먼저 out을 초기화하고 생성하면 된다.
	*/
	out.clear();
	out = pageContext.pushBody();
	
	BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
	BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	
	int size = (int) file.length();
	byte[] b = new byte[size]; // 파일의 크기만큼 배열사이즈를 잡아줌.
	bis.read(b, 0, size);	// 읽고
	bos.write(b);	// 보내기
	bis.close();
	bos.close();
%>
<!-- 
	* IO Stream
	1. byte 단위
	InputStream (추상클래스) new안됨
	OutputStream
	
	2. 문자 단위(2byte)
	Reader
	Writer
 	
 					 BufferedInputStream		 FileInputStream
 					 <------------------  buffer <---------------- storage(file들)
			파일
					 -------------------> buffer -----------------> 원하는 위치 / 파일명
	
 -->