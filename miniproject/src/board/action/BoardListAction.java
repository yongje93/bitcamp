package board.action;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 세션
		String memId = "";
		HttpSession session = request.getSession();
		if((String)session.getAttribute("memId") != null) {
			memId = (String) session.getAttribute("memId");
		}
		
		// 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// DB - 1페이지당 5개씩
		int endNum = pg*5;
		int startNum = endNum - 4;
		BoardDAO boardDAO = BoardDAO.getInstance();
		List<BoardDTO> boardList = boardDAO.boardList(startNum, endNum);
		
		// 페이징 처리
		BoardPaging boardPaging = new BoardPaging();
		int totalA = boardDAO.getTotalA();// 총글수
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		
		// 조회수 - 새로고침 방지
		if(session.getAttribute("memId") != null) {
			Cookie cookie = new Cookie("memhit", "0");
			cookie.setMaxAge(30*60);
			response.addCookie(cookie); //클라이언트에게 보내기
		}
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("boardPaging", boardPaging);
		request.setAttribute("pg", pg);
		request.setAttribute("memId", memId);
		request.setAttribute("display", "/board/boardList.jsp");
		
		return "/main/index.jsp";
	}
}
