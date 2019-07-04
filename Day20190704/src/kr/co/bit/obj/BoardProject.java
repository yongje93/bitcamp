package kr.co.bit.obj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class BoardProject {

	public static void main(String[] args) {
		Register register = new Register();
		Search search = new Search();
		Delete delete = new Delete();
		Update update = new Update();
		List list = new List();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			while (true) {
				conn = Board.getConnection();
				if (conn == null) {
					System.out.println("오라클 연결 실패");
				} else {
					System.out.println("오라클 연결 성공");
					System.out.println("====게시판 작성====");
					System.out.println("R: 등록  S: 검색  D: 삭제  U: 수정  L: 목록  X: 종료");
					String protocol = br.readLine();
					if (protocol.equals("R") || protocol.equals("r")) { // 등록
						register.registerProcess();
					} else if (protocol.equals("S") || protocol.equals("s")) { // 검색
						search.searchProcess();
					} else if (protocol.equals("D") || protocol.equals("d")) { // 삭제
						delete.deleteProcess();
					} else if (protocol.equals("U") || protocol.equals("u")) { // 수정
						update.updatePorcess();
					} else if (protocol.equals("L") || protocol.equals("l")) { // 전체출력, 목록
						list.listPorcess();
					} else if (protocol.equals("X") || protocol.equals("x")) { // 종료
						conn.close();
						System.out.println("프로그램 종료");
						System.exit(0);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
