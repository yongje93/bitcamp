package kr.co.bit.obj1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search {
	private Connection conn;
	private int no; // ��ȣ
	private String title; // ����
	private String content; // ����
	private String author; // �ۼ���
	private String day; // ��¥
	private int readcount; // ��ȸ��
	private String titleSearch; // ã�� �Խñ� ����
	private PreparedStatement pstmt;
	private String sql;
	private ResultSet rs;

	public Search() {
		no = 0;
		title = null;
		content = null;
		author = null;
		day = null;
		readcount = 0;
		titleSearch = null;
		pstmt = null;
		sql = null;
		rs = null;
		conn = null;
	}

	public void searchTitle() throws IOException {
		System.out.print("ã�� �Խñ� �����Է�: ");
		titleSearch = Register.br.readLine();
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
		conn = Register.getConnection();
		searchTitle();
		boardSqlSearch();
		boardSqlExecute();
		rs.close();
		pstmt.close();
		conn.close();
	}
}
