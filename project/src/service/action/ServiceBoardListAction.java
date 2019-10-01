package service.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import service.bean.ServiceDTO;
import service.dao.ServiceDAO;

public class ServiceBoardListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// DB - 1페이지당 5개씩
		int endNum = pg*5;
		int startNum = endNum - 4;
		ServiceDAO serviceDAO = ServiceDAO.getInstance();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		List<ServiceDTO> serviceboardList = serviceDAO.boardList(map);
		
		request.setAttribute("serviceboardList", serviceboardList);
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/member/memberInfo.jsp");
		request.setAttribute("myDisplay", "/service/serviceoardList.jsp");
		return "/main/index.jsp";
	}

}
