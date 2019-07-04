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
					System.out.println("����Ŭ ���� ����");
				} else {
					System.out.println("����Ŭ ���� ����");
					System.out.println("====�Խ��� �ۼ�====");
					System.out.println("R: ���  S: �˻�  D: ����  U: ����  L: ���  X: ����");
					String protocol = br.readLine();
					if (protocol.equals("R") || protocol.equals("r")) { // ���
						boardPoly.boardSQL(register);
						register.boardProcess();
						boardPoly.boardClose(register);
					} else if (protocol.equals("S") || protocol.equals("s")) { // �˻�
						boardPoly.boardSQL(search);
						search.boardProcess();
						boardPoly.boardClose(search);
					} else if (protocol.equals("D") || protocol.equals("d")) { // ����
						boardPoly.boardSQL(delete);
						delete.boardProcess();
						boardPoly.boardClose(delete);
					} else if (protocol.equals("U") || protocol.equals("u")) { // ����
						boardPoly.boardSQL(update);
						update.boardProcess();
						boardPoly.boardClose(update);
					} else if (protocol.equals("L") || protocol.equals("l")) { // ��ü���, ���
						boardPoly.boardSQL(list);
						list.boardProcess();
						boardPoly.boardClose(list);
					} else if (protocol.equals("X") || protocol.equals("x")) { // ����
						conn.close();
						System.out.println("���α׷� ����");
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
