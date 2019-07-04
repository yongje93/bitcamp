package kr.co.bit.obj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class BoardProject {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Register register = new Register();
		Search search = new Search();
		Delete delete = new Delete();
		Update update = new Update();
		List list = new List();
	
		BoardPoly boardPoly = new BoardPoly();
		
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
						boardPoly.boardSQL(register);
						register.boardProcess();
						boardPoly.boardClose(register);
					} else if (protocol.equals("S") || protocol.equals("s")) { // 검색
						boardPoly.boardSQL(search);
						search.boardProcess();
						boardPoly.boardClose(search);
					} else if (protocol.equals("D") || protocol.equals("d")) { // 삭제
						boardPoly.boardSQL(delete);
						delete.boardProcess();
						boardPoly.boardClose(delete);
					} else if (protocol.equals("U") || protocol.equals("u")) { // 수정
						boardPoly.boardSQL(update);
						update.boardProcess();
						boardPoly.boardClose(update);
					} else if (protocol.equals("L") || protocol.equals("l")) { // 전체출력, 목록
						boardPoly.boardSQL(list);
						list.boardProcess();
						boardPoly.boardClose(list);
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
