package service.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import service.bean.ServiceboardDTO;
import service.dao.ServiceboardDAO;

public class ServiceBoardViewAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));

		// DB
		ServiceboardDAO serviceboardDAO = ServiceboardDAO.getInstance();
		ServiceboardDTO serviceboardDTO = serviceboardDAO.getBoard(seq);

		//응답
		request.setAttribute("serviceboardDTO", serviceboardDTO);
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/member/memberInfo.jsp");
		request.setAttribute("myDisplay", "/service/serviceboardView.jsp");
		return "/main/index.jsp";
	}

}
