package kr.co.bit.obj1;

import java.io.IOException;
import java.sql.SQLException;

public class Search extends Board {
	private String titleSearch; // 찾는 게시글 제목

	public Search() {
		super();
		titleSearch = null;
	}

	public void searchTitle() throws IOException {
		System.out.print("찾는 게시글 제목입력: ");
		titleSearch = br.readLine();
	}

	public void boardSQL() {
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD WHERE TITLE = ?";
	}

	public void boardSqlExecute() throws SQLException {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, titleSearch);
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
	
	public void boardProcess() throws IOException, SQLException {
		conn = getConnection();
		searchTitle();
		boardSQL();
		boardTitle();
		boardSqlExecute();
		//closeAll();
		//boardClose();
	}
}
