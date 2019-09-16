package imageboard.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import imageboard.bean.ImageboardDTO;

public class ImageboardDAO {
	private static ImageboardDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	// 싱글톤
	public static ImageboardDAO getInstance() {
		if(instance == null) {
			synchronized (ImageboardDAO.class) {
				instance = new ImageboardDAO();
			}
		}
		return instance;
	}
	
	public ImageboardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 이미지 게시판 작성
	public void imageboardWrite(ImageboardDTO imageboardDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("imageboardSQL.imageboardWrite", imageboardDTO);
		sqlSession.commit();
		sqlSession.close();
	}
}
