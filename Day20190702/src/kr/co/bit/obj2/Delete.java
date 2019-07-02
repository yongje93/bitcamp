package kr.co.bit.obj2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
	public static BufferedReader br;
	private static Connection conn;
	private String titleDelete; // ������ �Խñ� ����
	private PreparedStatement pstmt;
	private String sql;
	private int cnt;

	static {
		br = new BufferedReader(new InputStreamReader(System.in));
		conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Delete() {
		titleDelete = null;
		pstmt = null;
		sql = null;
		cnt = 0;
	}
	
	public void deleteTitle() throws IOException {
		System.out.print("������ �Խñ� ���� �Է�: ");
		titleDelete = br.readLine();
	}
	
	public void boardSqlDelete() {
		sql = "DELETE FROM BOARD WHERE TITLE = ?";
	}
	
	public void boardSqlExecute() throws SQLException {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, titleDelete);
		cnt = pstmt.executeUpdate();
	}
		
	
	public void deleteProcess() throws IOException, SQLException {
		conn = Register.getConnection();
		deleteTitle();
		boardSqlDelete();
		boardSqlExecute();
		if (cnt == 0) {
			System.out.println("���� ����");
		} else {
			System.out.println(cnt + "���� �Խñ��� �����Ǿ����ϴ�.");
		}
		pstmt.close();
		conn.close();
	}
}
