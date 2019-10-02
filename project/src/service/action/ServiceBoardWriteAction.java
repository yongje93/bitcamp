package service.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import service.bean.ServiceboardDTO;
import service.dao.ServiceboardDAO;

public class ServiceBoardWriteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 데이터
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("memId");
		String name = (String) session.getAttribute("memName");
		
		ServiceboardDTO serviceboardDTO = new ServiceboardDTO();
		serviceboardDTO.setId(id);
		serviceboardDTO.setName(name);
		serviceboardDTO.setSubject(subject);
		serviceboardDTO.setContent(content);
		
		// DB
		ServiceboardDAO serviceboardDAO = ServiceboardDAO.getInstance();
		serviceboardDAO.boardWrite(serviceboardDTO);
		
		return "/service/serviceboardWrite.jsp";
	}

}
