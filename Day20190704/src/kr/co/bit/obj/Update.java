package kr.co.bit.obj;

import java.io.IOException;
import java.sql.SQLException;

public class Update extends Board {
	private String titleUpdate;

	public Update() {
		super();
		titleUpdate = null;
	}

	public void updateTitle() throws IOException {
		System.out.print("수정할 게시글 제목 입력: ");
		titleUpdate = br.readLine();
	}

	public void oldBoardSqlSearch() {
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD WHERE TITLE = ?";
	}

	public void updateTitleContent() throws IOException {
		System.out.print("수정할 제목|내용 입력: ");
		titleContent = br.readLine();
	}

	public void boardSqlUpdate() {
		sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE TITLE = ?";
	}

	public void boardSqlExecute() throws SQLException {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, titleUpdate);
		cnt = pstmt.executeUpdate();
		if (cnt == 0) {
			System.out.println("수정 실패");
		} else {
			System.out.println(cnt + "건의 게시글이 수정되었습니다.");
		}
	}

	public void updatePorcess() throws IOException, SQLException {
		conn = getConnection();
		updateTitle();
		oldBoardSqlSearch();
		boardTitle();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, titleUpdate);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			no = rs.getInt("no");
			title = rs.getString("title");
			content = rs.getString("content");
			author = rs.getString("author");
			day = rs.getString("day");
			readcount = rs.getInt("readcount");
			System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" + day + "\t" + readcount + "\n");
		}
		updateTitleContent();
		titleContentPorcess();
		boardSqlUpdate();
		boardSqlExecute();
		closeAll();

	}
}
