package member.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 데이터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		
		// DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberDTO memberDTO = memberDAO.login(map);
		
		// 응답
		String loginResult = null;
		if(memberDTO == null) {
			loginResult = "fail";
		} else {
			// 세션
			loginResult ="ok";
			HttpSession session = request.getSession();	// java에는 내장객체가 없으니까 세션 생성
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memId", memberDTO.getId());
		}
		request.setAttribute("loginResult", loginResult);

		return "/member/loginResult.jsp";
	}

}
