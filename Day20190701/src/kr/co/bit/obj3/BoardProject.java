package kr.co.bit.obj3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardProject {

	public static void main(String[] args) {
		// 1.로드 Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2.연결 Connection conn = DriverManager.getConnection(url, id, pw);
		// 3.준비
		// 4.실행 executeQuery(검색,전체출력) executeUpdate(등록, 삭제, 수정)
		// 5.종료
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 키보드 입력 (Scanner 대신에 씀)

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			while (true) {
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin",
						"dkdlxl");
				if (conn == null) {
					System.out.println("오라클 연결 실패");
				} else {
					System.out.println("오라클 연결 성공");

					System.out.println("====게시판 작성====");

					System.out.println("R: 등록  S: 검색  D: 삭제  U: 수정  L: 목록");
					String protocol = br.readLine();
					if (protocol.equals("R") || protocol.equals("r")) { // 등록
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
					} else if (protocol.equals("S") || protocol.equals("s")) { // 검색
						System.out.print("찾는 게시글 제목입력: ");
						String titleSearch = br.readLine();

						System.out.print("번호\t제목\t내용\t작성자\t날짜\t조회수\n");
						String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD WHERE TITLE = ?";
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, titleSearch);
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.print(rs.getInt(1) + "\t");
							System.out.print(rs.getString(2) + "\t");
							System.out.print(rs.getString(3) + "\t");
							System.out.print(rs.getString(4) + "\t");
							System.out.print(rs.getString(5) + "\t");
							System.out.print(rs.getInt(6) + "\n");
						}
						rs.close();
						pstmt.close();
						conn.close();
					} else if (protocol.equals("D") || protocol.equals("d")) { // 삭제
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
					} else if (protocol.equals("U") || protocol.equals("u")) { // 수정
						System.out.print("수정할 게시글 제목 입력: ");
						String titleUpdate = br.readLine();
						System.out.println("수정 전 내용입니다.");
						System.out.print("번호\t제목\t내용\t작성자\t날짜\t조회수\n");
						String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD WHERE TITLE = ?";
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, titleUpdate);
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.print(rs.getInt(1) + "\t");
							System.out.print(rs.getString(2) + "\t");
							System.out.print(rs.getString(3) + "\t");
							System.out.print(rs.getString(4) + "\t");
							System.out.print(rs.getString(5) + "\t");
							System.out.print(rs.getInt(6) + "\n");

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
						}
						rs.close();
						pstmt.close();
						conn.close();

					} else if (protocol.equals("L") || protocol.equals("l")) { // 전체출력, 목록
						System.out.println("====전체출력====");
						System.out.print("번호\t제목\t내용\t작성자\t날짜\t조회수\n");
						String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD ORDER BY NO ASC";
						PreparedStatement pstmt = conn.prepareStatement(sql);
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.print(rs.getInt(1) + "\t");
							System.out.print(rs.getString(2) + "\t");
							System.out.print(rs.getString(3) + "\t");
							System.out.print(rs.getString(4) + "\t");
							System.out.print(rs.getString(5) + "\t");
							System.out.print(rs.getInt(6) + "\n");
						}
						rs.close();
						pstmt.close();
						conn.close();
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
