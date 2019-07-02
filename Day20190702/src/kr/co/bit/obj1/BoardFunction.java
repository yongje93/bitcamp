package kr.co.bit.obj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardFunction {
	public void register(BufferedReader br, Connection conn) throws NumberFormatException, IOException, SQLException {
		System.out.print("게시글번호입력: ");
		int no = Integer.parseInt(br.readLine());
		System.out.print("제목|내용입력: ");
		String titleContent = br.readLine();
		int indexI = titleContent.indexOf("|");
		String title = titleContent.substring(0, indexI);
		String content = titleContent.substring(indexI + 1);

		String sql = "INSERT INTO BOARD(NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT) VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.setString(2, title);
		pstmt.setString(3, content);
		pstmt.setString(4, "신용제");
		pstmt.setString(5, "20190701");
		pstmt.setInt(6, 0);

		int cnt = pstmt.executeUpdate();

		if (cnt == 0) {
			System.out.println("등록 실패");
		} else {
			System.out.println(cnt + "건의 게시글이 등록되었습니다.");
		}
		pstmt.close();
		conn.close();

	}

	public void search(BufferedReader br, Connection conn) throws NumberFormatException, IOException, SQLException {
		System.out.print("찾는 게시글 제목입력: ");
		String titleSearch = br.readLine();

		System.out.print("번호\t제목\t내용\t작성자\t날짜\t조회수\n");
		String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD WHERE TITLE = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, titleSearch);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String day = rs.getString("day");
			int readcount = rs.getInt("readcount");
			System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" + day + "\t" + readcount + "\n");
		}
		rs.close();
		pstmt.close();
		conn.close();
	}

	public void delete(BufferedReader br, Connection conn) throws NumberFormatException, IOException, SQLException {
		System.out.print("삭제할 게시글 제목 입력: ");
		String titleDelete = br.readLine();

		String sql = "DELETE FROM BOARD WHERE TITLE = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, titleDelete);
		int cnt = pstmt.executeUpdate();
		if (cnt == 0) {
			System.out.println("삭제 실패");
		} else {
			System.out.println(cnt + "건의 게시글이 삭제되었습니다.");
		}
		pstmt.close();
		conn.close();
	}

	public void update(BufferedReader br, Connection conn) throws NumberFormatException, IOException, SQLException {
		System.out.print("수정할 게시글 제목 입력: ");
		String titleUpdate = br.readLine();
		System.out.println("수정 전 내용입니다.");
		System.out.print("번호\t제목\t내용\t작성자\t날짜\t조회수\n");
		String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD WHERE TITLE = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, titleUpdate);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String day = rs.getString("day");
			int readcount = rs.getInt("readcount");
			System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" + day + "\t"	+ readcount + "\n");
		}
		System.out.println("해당 게시글이 검색 되었습니다.");
		System.out.print("수정할 제목|내용 입력: ");
		String titleContent = br.readLine();
		int indexI = titleContent.indexOf("|");
		String title = titleContent.substring(0, indexI);
		String content = titleContent.substring(indexI + 1);

		sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE TITLE = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, titleUpdate);

		int cnt = pstmt.executeUpdate();
		if (cnt == 0) {
			System.out.println("수정 실패");
		} else {
			System.out.println(cnt + "건의 게시글이 수정되었습니다.");
		}
		rs.close();
		pstmt.close();
		conn.close();

	}

	public void list(Connection conn) throws SQLException {
		System.out.println("====전체출력====");
		System.out.print("번호\t제목\t내용\t작성자\t날짜\t조회수\n");
		String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD ORDER BY NO ASC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String day = rs.getString("day");
			int readcount = rs.getInt("readcount");
			System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" + day + "\t"	+ readcount + "\n");
		}
		rs.close();
		pstmt.close();
		conn.close();
	}

}
