package kr.co.bit.obj2;

import java.sql.SQLException;

public class List extends Board implements BoardInterface {

	public List() {
		super();
	}

	@Override
	public void boardSQL() {
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD ORDER BY NO ASC";
	}

	public void boardSqlExecute() throws SQLException {
		pstmt = conn.prepareStatement(sql);
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

	@Override
	public void boardProcess() throws SQLException {
		conn = getConnection();
		boardTitle();
		boardSQL();
		boardSqlExecute();
		// closeAll();
		// boardClose();
	}

}
