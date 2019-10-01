package member.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

public class LogoutAction implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 세션
		HttpSession session = request.getSession();
		session.invalidate();
		
		//로그인 관련 쿠키 삭제
	    Cookie[] cookies = request.getCookies();
	    if(cookies != null){
	        for(Cookie tempCookie : cookies){
	            if(tempCookie.getName().equals("id")) {
	                tempCookie.setMaxAge(0);
	                tempCookie.setPath("/");
	                response.addCookie(tempCookie);
	            }
	        }
	    }
				
		request.setAttribute("display", "/member/logout.jsp");
		return "/main/index.jsp";
	}

}
