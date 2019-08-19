package com.hello;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	public void init() {
		System.out.println("init()..");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, java.io.IOException {
		System.out.println("doGet()..");
		
		// 응답 (웹에 출력해주기)
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();	// 생성
		out.println("<html>");
		out.println("<body>");
		out.println("Hello Servlet!!!<br>");
		out.println("안녕하세요 서블릿");
		out.println("</body>");
		out.println("</html>");
		
	}

	public void destroy() {
		System.out.println("destroy()..");
	}
}
