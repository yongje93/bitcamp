package guestbook.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
		int pg = Integer.parseInt(request.getParameter("pg"));	// 페이징 처리값 받아오기.
		
		// DB
		// 페이징 처리
		int endNum = pg*2;
		int startNum = endNum - 1;
	
		GuestbookDAO guestbookDAO = new GuestbookDAO();	
		List<GuestbookDTO> list = guestbookDAO.getList(startNum, endNum);
		
		// 총글수
		int totalA = guestbookDAO.getTotalA();
		// 총페이지수
		int totalP = (totalA+1)/2;		// 10개일  때 (total+9)/10

		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style type='text/css'>");
		out.println("pre { overflow: auto; width: 100%; height: 100px; white-space: pre-line; word-break: break-all; }");
		out.println("#currentPaging { color: red; text-decoration: underline; }");
		out.println("#paging { color: black; text-decoration: none; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		if(list!=null) {
			for(int i = 1; i <= totalP; i++) {
				if(i == pg) //현재 페이지라면
					out.println("[<a id=currentPaging href='/guestbookServlet/GuestbookListServlet?pg="+i+"'>"+i+"</a>]");
				else //아니라면
					out.println("[<a id=paging href='/guestbookServlet/GuestbookListServlet?pg="+i+"'>"+i+"</a>]");
			}
			out.println("<br><br>");
			//-----------------
			for(GuestbookDTO guestbookDTO : list) {
				out.println("<table border=1 width=400 cellspacing=0 cellpadding=5>");
				out.println("<tr>");
				out.println("<th width=100>작성자</th>");
				out.println("<td width=100>"+guestbookDTO.getName()+"</td>");
				out.println("<th width=100>작성일</th>");
				out.println("<td width=100>"+guestbookDTO.getLogtime()+"</td>");
				out.println("</tr>");
				
				out.println("<tr>");
				out.println("<th>이메일</th>");
				out.println("<td colspan=3>"+guestbookDTO.getEmail()+"</td>");
				out.println("</tr>");
				
				out.println("<tr>");
				out.println("<th>홈페이지</th>");
				out.println("<td colspan=3>"+guestbookDTO.getHomepage()+"</td>");
				out.println("</tr>");
				
				out.println("<tr>");
				out.println("<th>제목</th>");
				out.println("<td colspan=3>"+guestbookDTO.getSubject()+"</td>");
				out.println("</tr>");
				
				out.println("<tr>");
				out.println("<td colspan=4><pre>"+guestbookDTO.getContent()+"</pre></td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("<hr width=400 align=left color=red>");
			}
		}
		out.println("</body>");
		out.println("</html>");
	}
}
