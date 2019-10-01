package member.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class CheckPwdAction implements CommandProcess {

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
		String checkPwdResult = null;
		if(memberDTO == null) {
			checkPwdResult = "fail";
		} else {
			checkPwdResult = "ok";
		}
		request.setAttribute("checkPwdResult", checkPwdResult);
		return "/member/checkPwdResult.jsp";
	}

}
