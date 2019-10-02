package service.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import service.bean.ServiceboardDTO;

public class ServiceboardDAO {
	private static ServiceboardDAO instance;
	private SqlSessionFactory sqlSessionFactory;

	// 싱글톤
	public static ServiceboardDAO getInstance() {
		if (instance == null) {
			synchronized (ServiceboardDAO.class) {
				instance = new ServiceboardDAO();
			}
		}
		return instance;
	}

	public ServiceboardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 고객센터 목록
	public List<ServiceboardDTO> boardList(Map<String, Object> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ServiceboardDTO> serviceboardList = sqlSession.selectList("serviceSQL.serviceboardList", map);
		sqlSession.close();
		return serviceboardList;
	}

	// 고객센터 문의글 쓰기
	public void boardWrite(ServiceboardDTO serviceboardDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("serviceSQL.serviceboardWrite", serviceboardDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	// 고객센터 문의글 보기
	public ServiceboardDTO getBoard(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ServiceboardDTO serviceboardDTO = sqlSession.selectOne("serviceSQL.getBoard", seq);
		sqlSession.close();
		return serviceboardDTO;
	}

	// 전체 문의글 수
	public int getTotalA(Map<String, Object> map) {
		int totalBoard = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		totalBoard = sqlSession.selectOne("serviceSQL.getTotalA", map);
		sqlSession.close();
		return totalBoard;
	}

}
