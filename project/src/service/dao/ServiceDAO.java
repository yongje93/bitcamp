package service.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import service.bean.ServiceDTO;

public class ServiceDAO {
	private static ServiceDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	// 싱글톤
	public static ServiceDAO getInstance() {
		if(instance == null) {
			synchronized (ServiceDAO.class) {
				instance = new ServiceDAO();
			}
		}
		return instance;
	}
	
	public ServiceDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 고객센터 목록
	public List<ServiceDTO> boardList(Map<String, Object> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ServiceDTO> serviceboardList = sqlSession.selectList("serviceSQL.serviceboardList", map);
		sqlSession.close();
		return serviceboardList;
	}
	
	
	// 고객센터 글쓰기
	
	
}
