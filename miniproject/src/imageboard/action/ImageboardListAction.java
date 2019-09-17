package imageboard.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.ImageboardPaging;
import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageboardDAO;

public class ImageboardListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// DB - 1페이지당 3개씩
		int endNum = pg*3;
		int startNum = endNum - 2;
		ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		List<ImageboardDTO> imageboardList = imageboardDAO.imageboardList(map);
		
		// 페이징 처리
		ImageboardPaging imageboardPaging = new ImageboardPaging();
		int totalA = imageboardDAO.getTotalA(map);
		imageboardPaging.setCurrentPage(pg);
		imageboardPaging.setPageBlock(3);
		imageboardPaging.setPageSize(3);
		imageboardPaging.setTotalA(totalA);
		imageboardPaging.makePagingHTML();
		
		// 응답
		request.setAttribute("imageboardList", imageboardList);
		request.setAttribute("pg", pg);
		request.setAttribute("imageboardPaging", imageboardPaging);
		request.setAttribute("display", "/imageboard/imageboardList.jsp");
		
		return "/main/index.jsp";
	}

}
