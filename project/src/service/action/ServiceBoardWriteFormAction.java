package service.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class ServiceBoardWriteFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setAttribute("display", "/member/memberInfo.jsp");
		request.setAttribute("myDisplay", "/service/serviceboardWriteForm.jsp");
		return "/main/index.jsp";
	}

}
