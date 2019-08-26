package member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

//@WebServlet("/WriteServlet")	// xml 파일에서 작성한거랑 중복되면 충돌남
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; // 직렬화 버전

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 데이터
		request.setCharacterEncoding("UTF-8");	// post인 경우 한글안깨지게 해줘야됨
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1"); 
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String zipcode = request.getParameter("zipcode");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
				
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName(name);
		memberDTO.setId(id);
		memberDTO.setPassword(password);
		memberDTO.setGender(gender);
		memberDTO.setEmail1(email1);
		memberDTO.setEmail2(email2);
		memberDTO.setTel1(tel1);
		memberDTO.setTel2(tel2);
		memberDTO.setTel3(tel3);
		memberDTO.setZipcode(zipcode);
		memberDTO.setAddr1(addr1);
		memberDTO.setAddr2(addr2);
				
		// DB
		MemberDAO memberDAO = MemberDAO.getInstance();	// 싱글톤으로 불러오기
		int su = memberDAO.write(memberDTO);
	
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(su == 1) {
			out.println("회원가입을 축하합니다");
			out.println("<br><br>");
			out.println("<input type='button' value='로그인' onclick=location.href='/memberServlet/member/loginForm.html'>");
		}
		else
			out.println("다시 작성해주세요");
		out.println("</body>");
		out.println("</html>");
	}
	
}
