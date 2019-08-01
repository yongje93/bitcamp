package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "java";
	private String password = "dkdlxl";
	private Connection conn;
	private PreparedStatement pstmt;

	public UpdateTest() {
		try {
			Class.forName(driver);
			//System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
			//System.out.println("접속 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("수정할 이름 입력 : ");
		String name = scan.next();

		this.getConnection();	// 접속
		String sql = "update dbtest set age=age+1 where name like ?";
		try {
			pstmt = conn.prepareStatement(sql);	// 생성
			pstmt.setString(1, "%"+name+"%");
			int su = pstmt.executeUpdate();		// 실행 - 개수 리턴

			System.out.println(su + " row updated");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		UpdateTest ut = new UpdateTest();
		ut.updateArticle();
	}
}
