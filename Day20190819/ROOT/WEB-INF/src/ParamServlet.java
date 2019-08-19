package com.param;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)	
				throws ServletException, java.io.IOException {
		
		// 데이터
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.print("나의 이름은 " + name + "이고 내 나이는 " + age +"살 ");
		if(age>=20) out.println("성인입니다.");
		else out.println("청소년입니다.");
		out.println("<br><br>");
		out.println("<input type=button value=뒤로 onClick=javascript:history.go(-1)>");
		out.println("</body>");
		out.println("</html>");
	}

}
