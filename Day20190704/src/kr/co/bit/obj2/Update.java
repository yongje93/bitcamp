package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.SQLException;

public class Update extends Board implements BoardInterface {
	private String titleUpdate;
	Search search = new Search();

	public Update() {
		super();
		titleUpdate = null;
	}

	public void updateTitle() throws IOException {
		System.out.print("수정할 게시글 제목 입력: ");
		titleUpdate = br.readLine();
	}
	
	@Override
	public void boardSQL() {
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD WHERE TITLE = ?";
	}

	public void updateTitleContent() throws IOException {
		System.out.print("수정할 제목|내용 입력: ");
		titleContent = br.readLine();
	}

	public void oldBoardSqlExecute() throws SQLException {
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
	}

	public void updateBoardSQL() {
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

	@Override
	public void boardClose() {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void boardProcess() throws IOException, SQLException {
		conn = getConnection();
		updateTitle();
		// boardSQL();
		boardTitle();
		oldBoardSqlExecute();
		updateTitleContent();
		titleContentPorcess();
		updateBoardSQL();
		boardSqlExecute();
		// closeAll();
		// boardClose();
	}
}
