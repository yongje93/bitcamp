package service.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import service.bean.BoardPaging;
import service.bean.ServiceboardDTO;
import service.dao.ServiceboardDAO;

public class ServiceBoardListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));

		// DB - 1페이지당 10개씩
		int endNum = pg * 10;
		int startNum = endNum - 9;
		ServiceboardDAO serviceDAO = ServiceboardDAO.getInstance();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);

		List<ServiceboardDTO> serviceboardList = serviceDAO.boardList(map);

		// 페이징 처리
		BoardPaging boardPaging = new BoardPaging();
		int totalA = serviceDAO.getTotalA(map);// 총글수
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(10);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();

		request.setAttribute("serviceboardList", serviceboardList);
		request.setAttribute("pg", pg);
		request.setAttribute("boardPaging", boardPaging);
		request.setAttribute("display", "/member/memberInfo.jsp");
		request.setAttribute("myDisplay", "/service/serviceoardList.jsp");
		return "/main/index.jsp";
	}

}
