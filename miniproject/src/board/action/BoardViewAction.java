package board.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		// 조회수 -- 새로고침 방지
		Cookie[] ar = request.getCookies();
		if(ar != null) {
			for(int i=0; i < ar.length; i++) {
				if("memhit".equals(ar[i].getName())) {
					boardDAO.boardHit(seq); // 조회수 증가
					ar[i].setMaxAge(0); // 쿠키삭제
					response.addCookie(ar[i]); // 클라이언트에게 쿠키소멸 알려줌
				}
			}
		}
		
		BoardDTO boardDTO = boardDAO.getBoard(seq);

		// 응답
		request.setAttribute("boardDTO", boardDTO);
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardView.jsp");
		
		return "/main/index.jsp";
	}
}
