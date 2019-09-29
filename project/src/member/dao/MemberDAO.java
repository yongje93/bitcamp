package member.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;

public class MemberDAO {
	private static MemberDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
	public static MemberDAO getInstance() {
		if(instance == null) {
			synchronized (MemberDAO.class) {
				instance = new MemberDAO();
			}
		}
		return instance;
	}
	
	public MemberDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 회원가입
	public void write(MemberDTO memberDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("memberSQL.write", memberDTO);
		sqlSession.commit();
		sqlSession.close();
	}
	
	// 회원정보 수정
	
	// 로그인
	public MemberDTO login(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.login", map);
		sqlSession.close();
		return memberDTO;
	}
	
	// 아이디 중복 확인
	public boolean isExistId(String id) {
		boolean exist = false;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.isExistId", id);
		if(memberDTO!=null) {
			exist = true;
		}
		sqlSession.close();
		return exist;
	}
}
