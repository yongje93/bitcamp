package kr.co.bit.obj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Board {
	protected static BufferedReader br;
	public static Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	protected String sql; // 쿼리문
	protected int no; // 번호
	protected String title; // 제목
	protected String content; // 내용
	protected String author; // 작성자
	protected String day; // 작성일자
	protected int readcount; // 조회수
	protected int cnt; // executeUpdate문 반환값
	protected String titleContent; // 제목|내용
	protected int indexI; // "|" 문자의 위치 반환

	static {
		br = new BufferedReader(new InputStreamReader(System.in));
		conn = null;
	}

	public Board() {
		pstmt = null;
		rs = null;
		sql = null;
		no = 0;
		title = null;
		content = null;
		author = null;
		day = null;
		readcount = 0;
		cnt = 0;
		titleContent = null;
		indexI = 0;
	}

	public static Connection getConnection() throws SQLException { // 연결.
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
		return conn;
	}
	
	public void boardTitle() {
		System.out.print("번호\t제목\t내용\t작성자\t날짜\t\t조회수\n");
	}
	
	public void titleContentPorcess() { // 제목|이름 으로 입력하면 나눠서 저장
		indexI = titleContent.indexOf("|");
		title = titleContent.substring(0, indexI);
		content = titleContent.substring(indexI + 1);
	}
	
	public abstract void boardSQL();	
	public abstract void boardClose();
	//public abstract void boardSqlExecute() throws SQLException;
	public abstract void boardProcess() throws IOException, SQLException;
	
	public void closeAll() { // rs, pstmt, conn close해주는 함수.
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
