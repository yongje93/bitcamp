package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 세션
//		String memId = (String) session.getAttribute("memId");
		String memId = "hong";
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		
//		// 조회수 -- 새로고침 방지
//		Cookie[] ar = request.getCookies();
//		if(ar != null) {
//			for(int i=0; i<ar.length; i++) {
//				if("memhit".equals(ar[i].getName())) {
//					boardDAO.boardHit(seq); // 조회수 증가
//					
//					ar[i].setMaxAge(0); // 쿠키삭제
//					response.addCookie(ar[i]); // 클라이언트에 저장
//				}
//			}
//		}
		
		// 게시글 가져오기
		BoardDTO boardDTO = boardDAO.getBoard(seq);
		request.setAttribute("boardDTO", boardDTO);
		request.setAttribute("memId", memId);
		request.setAttribute("pg", pg);
		
		return "/board/boardView.jsp";
	}
}
