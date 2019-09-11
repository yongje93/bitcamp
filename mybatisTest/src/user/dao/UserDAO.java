package user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	private static UserDAO instance;
	private SqlSessionFactory sqlSessionFactory;	// 현재 환경설정에 대한 정보를 읽어옴
	
	public UserDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 싱글톤
	public static UserDAO getInstance() {
		if(instance == null) {
			synchronized (UserDAO.class) {
				instance = new UserDAO();
			}
		}
		return instance;
	}
	// 입력
	public void wirte(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); // 생성, SqlSession으로 mapper 파일에 접근
		int su = sqlSession.insert("userSQL.write", userDTO); 	// ("mapper에서 이름", 데이터)
		sqlSession.commit();
		sqlSession.close();
	}
	// 출력
	public List<UserDTO> getList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.getList");
		sqlSession.close();
		return list;
	}
	// 찾기
	public UserDTO getUser(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDTO userDTO = sqlSession.selectOne("userSQL.getUser", id);
		sqlSession.close();
		return userDTO;
	}
	// 수정
	public void update(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su = sqlSession.update("userSQL.update", map);
		sqlSession.commit();
		sqlSession.close();
	}	
	// 삭제
	public void delete(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("userSQL.delete", id);
		sqlSession.commit();
		sqlSession.close();
	}
	// 검색
	public List<UserDTO> search(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.search", map);
		sqlSession.close();
		return list;
	}
}
