package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.SQLException;

public class Delete extends Board {
	private String titleDelete; // ������ �Խñ� ����

	public Delete() {
		super();
		titleDelete = null;
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
		if (cnt == 0) {
			System.out.println("���� ����");
		} else {
			System.out.println(cnt + "���� �Խñ��� �����Ǿ����ϴ�.");
		}
	}

	public void deleteProcess() throws IOException, SQLException {
		conn = getConnection();
		deleteTitle();
		boardSqlDelete();
		boardSqlExecute();
		closeAll();
	}
}
