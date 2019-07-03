package kr.co.bit.obj2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Update {
	private static BufferedReader br;
	private static Connection conn;
	private String titleUpdate;
	private PreparedStatement pstmt;
	private String sql;
	private ResultSet rs;
	private int cnt;
	private int no; // 번호
	private String title; // 제목
	private String content; // 내용
	private String author; // 작성자
	private String day; // 날짜
	private int readcount; // 조회수
	private String titleContent; // 제목|내용
	private int indexI; // "|" 문자의 위치를 반환
	private String titleNew; // 새로운 제목
	private String contentNew; // 새로운 내용

	static {
		br = new BufferedReader(new InputStreamReader(System.in));
		conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Update() {
		titleUpdate = null;	pstmt = null; sql = null;
		rs = null; cnt = 0; no = 0; title = null;
		content = null; author = null; day = null;
		readcount = 0; titleContent = null;
		indexI = 0;	titleNew = null; contentNew = null;
	}

	public void updateTitle() throws IOException {
		System.out.print("수정할 게시글 제목 입력: ");
		titleUpdate = br.readLine();	
	}
	
	public void oldBoardSqlSearch() {
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD WHERE TITLE = ?";
	}
	
	public void oldBoardSqlExecute() throws SQLException {
		System.out.println("수정 전 내용입니다.");
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
			System.out.print("번호\t제목\t내용\t작성자\t날짜\t조회수\n");
			System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" + day + "\t" + readcount + "\n");
		}
		System.out.println("해당 게시글이 검색 되었습니다.");	
	}
	
	public void updateTitleContent() throws IOException {
		System.out.print("수정할 제목|내용 입력: ");
		titleContent = br.readLine();
	}
	
	public void titleContentPorcess() {
		indexI = titleContent.indexOf("|");
		titleNew = titleContent.substring(0, indexI);
		contentNew = titleContent.substring(indexI + 1);
	}
	
	public void boardSqlUpdate() {
		sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE TITLE = ?";		
	}
	
	public void boardSqlExecute() throws SQLException {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, titleNew);
		pstmt.setString(2, contentNew);
		pstmt.setString(3, titleUpdate);
		cnt = pstmt.executeUpdate();
	}
	public void updatePorcess() throws IOException, SQLException {
		conn = Register.getConnection();
		updateTitle();
		oldBoardSqlSearch();
		oldBoardSqlExecute();
		updateTitleContent();
		titleContentPorcess();
		boardSqlUpdate();
		boardSqlExecute();
		
		if (cnt == 0) {
			System.out.println("수정 실패");
		} else {
			System.out.println(cnt + "건의 게시글이 수정되었습니다.");
		}
		rs.close();
		pstmt.close();
		conn.close();

	}
}
