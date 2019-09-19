package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardDeleteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		// DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardDelete(seq);
		// 응답
		request.setAttribute("display", "/board/boardDelete.jsp");
	
		return "/main/index.jsp";
	}
}
