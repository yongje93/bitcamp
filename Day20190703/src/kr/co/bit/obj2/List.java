package kr.co.bit.obj2;

import java.sql.SQLException;

public class List extends Board {

	public List() {
		super();
	}

	public void boardTitle() {
		System.out.println("====��ü���====");
		System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��\n");
	}

	public void boardSqlList() {
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

	public void listPorcess() throws SQLException {
		conn = getConnection();
		boardTitle();
		boardSqlList();
		boardSqlExecute();
		closeAll();
	}

}
