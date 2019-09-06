package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardWriteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 데이터
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		//String id = (String) session.getAttribute("memId");
		//String name = (String) session.getAttribute("memName");
		//String email = (String) session.getAttribute("memEmail");
		
		String id = "hong";
		String name = "홍길동";
		String email = "hong@naver.com";
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setId(id);
		boardDTO.setName(name);
		boardDTO.setEmail(email);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		
		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardWrite(boardDTO);
		
		return "/board/boardWrite.jsp";
	}

}
