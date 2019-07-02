package kr.co.bit.obj2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search {
	public static BufferedReader br;
	private static Connection conn;
	private int no; // 번호
	private String title; // 제목
	private String content; // 내용
	private String author; // 작성자
	private String day; // 날짜
	private int readcount; // 조회수
	private String titleSearch; // 찾는 게시글 제목
	private PreparedStatement pstmt;
	private String sql;
	private ResultSet rs;

	static {
		br = new BufferedReader(new InputStreamReader(System.in));
		conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Search() {
		no = 0;	title = null; content = null;	author = null;	
		day = null;	readcount = 0;	titleSearch = null;
		pstmt = null; sql = null; rs = null;
	}

	public void searchTitle() throws IOException {
		System.out.print("찾는 게시글 제목입력: ");
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
		System.out.print("번호\t제목\t내용\t작성자\t날짜\t조회수\n");
		boardSqlSearch();
		boardSqlExecute();
		rs.close();
		pstmt.close();
		conn.close();
	}
}
