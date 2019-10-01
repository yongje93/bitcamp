package main.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

public class IndexAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		
		Cookie[] cookies = request.getCookies();
	    if(cookies !=null){
	        for(Cookie tempCookie : cookies){
	            if(tempCookie.getName().equals("id")){
	                session.setAttribute("memId", tempCookie.getValue());
	            }
	        }
	    }
		request.setAttribute("display", "/template/body.jsp");
		return "/main/index.jsp";
	}

}
