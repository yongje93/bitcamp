package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.SQLException;

public class Delete extends Board {
	private String titleDelete; // 삭제할 게시글 제목

	public Delete() {
		super();
		titleDelete = null;
	}

	public void deleteTitle() throws IOException {
		System.out.print("삭제할 게시글 제목 입력: ");
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
			System.out.println("삭제 실패");
		} else {
			System.out.println(cnt + "건의 게시글이 삭제되었습니다.");
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
