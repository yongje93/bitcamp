package kr.co.bit.obj1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
	private Connection conn;
	private String titleDelete; // 삭제할 게시글 제목
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
		System.out.print("삭제할 게시글 제목 입력: ");
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
			System.out.println("삭제 실패");
		} else {
			System.out.println(cnt + "건의 게시글이 삭제되었습니다.");
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
