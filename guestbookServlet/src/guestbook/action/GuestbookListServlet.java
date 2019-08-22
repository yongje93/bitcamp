package guestbook.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

@WebServlet("/GuestbookListServlet")
public class GuestbookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터
		ArrayList<GuestbookDTO> guestbookList = null;
		
		// DB
		GuestbookDAO guestbookDAO = new GuestbookDAO();
		guestbookList = guestbookDAO.bookList();
		
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>글목록</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>글목록</h1>");
		for(GuestbookDTO dto : guestbookList) {
			out.println("<form name='listFrom'>");
			out.println("<table border=1 cellspacing=0 cellpadding=5>");
			out.println("<tr>");
			out.println("<th style='width: 80px;'>작성자</th>");
			out.println("<td style='width: 100px;'>"+dto.getName()+"</td>");
			out.println("<th style='width: 80px;'>작성일</th>");
			out.println("<td style='width: 150px;'>"+dto.getLogtime()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th style='width: 80px;'>이메일</th>");
			out.println("<td colspan=3>"+dto.getEmail()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th style='width: 80px;'>홈페이지</th>");
			out.println("<td colspan=3>"+dto.getHomepage()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th style='width: 80px;'>제목</th>");
			out.println(" <td colspan=3>"+dto.getSubject()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td colspan=4 style='width: 400px;'> <pre style='white-space: pre-wrap;'>"+dto.getContent()+"</pre></td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</form>");
			out.println("<br><br>");
		}
		out.println("</body>");
		out.println("</html>");
		
	}

}
