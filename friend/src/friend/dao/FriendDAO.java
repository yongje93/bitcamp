package friend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import friend.bean.FriendDTO;

public class FriendDAO { // DB만 처리하는 곳
	// 싱글톤처리
	private static FriendDAO instance; // 나 자신의 객체를 나타냄

	public static FriendDAO getInstance() {
		if (instance == null) {
			synchronized (FriendDAO.class) { // 한 개의 스레드만 들어오게 함
				instance = new FriendDAO(); // 여기는 한 번만 수행됨
			}
		}
		return instance;
	} // 싱글톤 처리 끝

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "java";
	private String password = "dkdlxl";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public FriendDAO() {
		try {
			Class.forName(driver); // 드라이버 로딩
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() { // 접속
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int insertFriend(FriendDTO dto) { // 등록
		int su = 0;
		getConnection(); // 접속
		String sql = "insert into friend values (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql); // 생성
			pstmt.setInt(1, dto.getSeq());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getTel1());
			pstmt.setString(4, dto.getTel2());
			pstmt.setString(5, dto.getTel3());
			pstmt.setInt(6, dto.getGender());
			pstmt.setInt(7, dto.getRead());
			pstmt.setInt(8, dto.getMovie());
			pstmt.setInt(9, dto.getMusic());
			pstmt.setInt(10, dto.getGame());
			pstmt.setInt(11, dto.getShopping());
			
			su = pstmt.executeUpdate(); // 실행 - 개수 리턴

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { // 종료
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return su;
	}
	
	public int updateFriend(FriendDTO dto) { // 수정
		int su = 0;
		getConnection();
		String sql = "update";
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteFriend(FriendDTO dto) { // 삭제
		int su = 0;
		getConnection();
		String sql = "delete";
		try {
			pstmt = conn.prepareStatement(sql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getseq() {
		int seq = 0;
		getConnection();
		String sql = "select seq_friend.nextval from dual";
		try {
			pstmt = conn.prepareStatement(sql); // 생성
			rs = pstmt.executeQuery(); // 실행
			
			if(rs.next()) seq = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { // 종료
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return seq;
	}
	
	public ArrayList<FriendDTO> getFriendList() {
		ArrayList<FriendDTO> arrayList = new ArrayList<FriendDTO>();
		getConnection();
		String sql = "select * from friend";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FriendDTO dto = new FriendDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setName(rs.getString("name"));
				dto.setTel1(rs.getString("tel1"));
				dto.setTel2(rs.getString("tel2"));
				dto.setTel3(rs.getString("tel3"));
				dto.setGender(rs.getInt("gender"));
				dto.setRead(rs.getInt("read"));
				dto.setMovie(rs.getInt("movie"));
				dto.setMusic(rs.getInt("music"));
				dto.setGame(rs.getInt("game"));
				dto.setShopping(rs.getInt("shopping"));
				
				arrayList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			arrayList = null;	//에러 발생 했을때 arrayList를 null 해줘야됨. 
		} finally {
			try { // 종료
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrayList;
	}
	
	public static void main(String[] args) {
		FriendDAO friendDAO = new FriendDAO();
	}

}
