package member.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
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
		String keepLogin = request.getParameter("keepLogin");
		System.out.println(keepLogin+"<--로그인 저장 여부");
		
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
			
			// 로그인 유지 처리
			if(keepLogin.equals("true")) {
				Cookie cookie = new Cookie("id",id);
				cookie.setMaxAge(60);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}
		request.setAttribute("loginResult", loginResult);
		return "/member/loginResult.jsp";
	}

}
