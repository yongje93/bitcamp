package kr.co.bit.obj1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
	private Connection conn;
	private String titleDelete; // ������ �Խñ� ����
	private PreparedStatement pstmt;
	private String sql;
	private int cnt;

	public Delete() {
		titleDelete = null;
		conn = null;
		pstmt = null;
		sql = null;
		cnt = 0;
	}

	public void deleteTitle() throws IOException {
		System.out.print("������ �Խñ� ���� �Է�: ");
		titleDelete = Register.br.readLine();
	}

	public void boardSqlDelete() {
		sql = "DELETE FROM BOARD WHERE TITLE = ?";
	}

	public void boardSqlExecute() throws SQLException {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, titleDelete);
		cnt = pstmt.executeUpdate();
		if (cnt == 0) {
			System.out.println("���� ����");
		} else {
			System.out.println(cnt + "���� �Խñ��� �����Ǿ����ϴ�.");
		}
	}

	public void deleteProcess() throws IOException, SQLException {
		conn = Register.getConnection();
		deleteTitle();
		boardSqlDelete();
		boardSqlExecute();
		pstmt.close();
		conn.close();
	}
}
