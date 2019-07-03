package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.SQLException;

public class Search extends Board {
	private String titleSearch; // ã�� �Խñ� ����

	public Search() {
		super();
		titleSearch = null;
	}

	public void searchTitle() throws IOException {
		System.out.print("ã�� �Խñ� �����Է�: ");
		titleSearch = br.readLine();
	}

	public void boardSqlSearch() {
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD WHERE TITLE = ?";
	}

	public void boardSqlExecute() throws SQLException {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, titleSearch);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��\n");
			no = rs.getInt("no");
			title = rs.getString("title");
			content = rs.getString("content");
			author = rs.getString("author");
			day = rs.getString("day");
			readcount = rs.getInt("readcount");
			System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" + day + "\t" + readcount + "\n");
		}
	}

	public void searchProcess() throws IOException, SQLException {
		conn = getConnection();
		searchTitle();
		boardSqlSearch();
		boardSqlExecute();
		closeAll();
	}
}
