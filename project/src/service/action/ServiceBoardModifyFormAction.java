package service.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import service.bean.ServiceboardDTO;
import service.dao.ServiceboardDAO;

public class ServiceBoardModifyFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));

		ServiceboardDAO serviceboardDAO = ServiceboardDAO.getInstance();
		ServiceboardDTO serviceboardDTO = serviceboardDAO.getBoard(seq);

		request.setAttribute("serviceboardDTO", serviceboardDTO);
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/member/memberInfo.jsp");
		request.setAttribute("myDisplay", "/service/serviceboardModifyForm.jsp");
		return "/main/index.jsp";
	}

}
