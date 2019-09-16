package board.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;

public class BoardDAO {
	private static BoardDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	// 싱글톤
	public static BoardDAO getInstance() {
		if(instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	}
	
	public BoardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 게시판 글쓰기
	public void boardWrite(BoardDTO boardDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("boardSQL.boardWrite", boardDTO);
		sqlSession.commit();
		sqlSession.close();
	}
	
	// 게시판 목록
	public List<BoardDTO> boardList(Map<String, Object> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardDTO> boardList = sqlSession.selectList("boardSQL.boardList", map);
		sqlSession.close();
		return boardList;
	}
	
	// 전체 게시글 수
	public int getTotalA(Map<String, Object> map) {
		int totalBoard = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		totalBoard = sqlSession.selectOne("boardSQL.getTotalA", map);
		sqlSession.close();
		return totalBoard;
	}
	
	// 게시글 보기
	public BoardDTO getBoard(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardDTO boardDTO = sqlSession.selectOne("boardSQL.getBoard", seq);
		sqlSession.close();
		return boardDTO;
	}
	
	// 조회수 증가
	public void boardHit(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("boardSQL.boardHit", seq);
		sqlSession.commit();
		sqlSession.close();
	}
	
	// 게시글 삭제
	public void boardDelete(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("boardSQL.boardDelete", seq);
		sqlSession.commit();
		sqlSession.close();
	}
	
	// 게시글 수정
	public void boardModify(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("boardSQL.boardModify", map);
		sqlSession.commit();
		sqlSession.close();
	}
}
