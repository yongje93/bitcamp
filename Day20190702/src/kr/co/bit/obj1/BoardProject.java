package kr.co.bit.obj1;

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
		BoardFunction bf = new BoardFunction();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			while (true) {
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
				if (conn == null) {
					System.out.println("오라클 연결 실패");
				} else {
					System.out.println("오라클 연결 성공");

					System.out.println("====게시판 작성====");

					System.out.println("R: 등록  S: 검색  D: 삭제  U: 수정  L: 목록");
					String protocol = br.readLine();
					if (protocol.equals("R") || protocol.equals("r")) { // 등록
						bf.register(br, conn);
					} else if (protocol.equals("S") || protocol.equals("s")) { // 검색
						bf.search(br, conn);
					} else if (protocol.equals("D") || protocol.equals("d")) { // 삭제
						bf.delete(br, conn);
					} else if (protocol.equals("U") || protocol.equals("u")) { // 수정
						bf.update(br, conn);
					} else if (protocol.equals("L") || protocol.equals("l")) { // 전체출력, 목록
						bf.list(conn);
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
