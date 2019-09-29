package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class WriteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 데이터
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String birthday = request.getParameter("birthday");
		String zipcode = request.getParameter("zipcode");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		System.out.println(name+","+id+","+pwd+","+email+","+tel+","+birthday+","+zipcode+","+addr1+","+addr2);
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName(name);
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		memberDTO.setEmail(email);
		memberDTO.setTel(tel);
		memberDTO.setBirthday(birthday);
		memberDTO.setZipcode(zipcode);
		memberDTO.setAddr1(addr1);
		memberDTO.setAddr2(addr2);
		
		// DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.write(memberDTO);
		
		request.setAttribute("display", "/member/write.jsp");
		return "/main/index.jsp";
	}

}
