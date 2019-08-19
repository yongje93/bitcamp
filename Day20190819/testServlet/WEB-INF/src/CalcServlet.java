package com.calc;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)	
				throws ServletException, java.io.IOException {
		
		// 데이터
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<font color=red>");
		out.println(x+" + "+y+" = "+(x+y)+"<br>");
		out.println(x+" - "+y+" = "+(x-y)+"<br>");
		out.println(x+" * "+y+" = "+(x*y)+"<br>");
		out.println(x+" / "+y+" = "+((double)x/y)+"<br>");
		out.println("<br><br>");
		out.println("<input type=button value=뒤로 onClick=javascript:history.go(-1)>");
		out.println("</body>");
		out.println("</html>");
	}
}
