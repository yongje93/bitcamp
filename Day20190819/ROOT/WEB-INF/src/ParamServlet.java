package com.param;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)	
				throws ServletException, java.io.IOException {
		
		// ������
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		// ����
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.print("���� �̸��� " + name + "�̰� �� ���̴� " + age +"�� ");
		if(age>=20) out.println("�����Դϴ�.");
		else out.println("û�ҳ��Դϴ�.");
		out.println("<br><br>");
		out.println("<input type=button value=�ڷ� onClick=javascript:history.go(-1)>");
		out.println("</body>");
		out.println("</html>");
	}

}
