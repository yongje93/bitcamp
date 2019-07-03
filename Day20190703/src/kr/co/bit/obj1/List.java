package kr.co.bit.obj1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class List {
	private Connection conn;
	private PreparedStatement pstmt;
	private int no; // 번호
	private String title; // 제목
	private String content; // 내용
	private String author; // 작성자
	private String day; // 날짜
	private int readcount; // 조회수
	private String sql;
	private ResultSet rs;

	public List() {
		no = 0;
		title = null;
		content = null;
		author = null;
		day = null;
		readcount = 0;
		pstmt = null;
		sql = null;
		rs = null;
		conn = null;
	}

	public void boardTitle() {
		System.out.println("====전체출력====");
		System.out.print("번호\t제목\t내용\t작성자\t날짜\t조회수\n");
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
		conn = Register.getConnection();
		boardTitle();
		boardSqlList();
		boardSqlExecute();
		rs.close();
		pstmt.close();
		conn.close();
	}

}
