package service.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import service.dao.ServiceboardDAO;

public class ServiceBoardModifyAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", seq);
		map.put("subject", subject);
		map.put("content", content);
		
		ServiceboardDAO serviceboardDAO = ServiceboardDAO.getInstance();
		serviceboardDAO.boardModify(map);
		
		request.setAttribute("pg", pg);
		
		return "/service/serviceboardModify.jsp";
	}

}
