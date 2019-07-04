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
					System.out.println("����Ŭ ���� ����");
				} else {
					System.out.println("����Ŭ ���� ����");
					System.out.println("====�Խ��� �ۼ�====");
					System.out.println("R: ���  S: �˻�  D: ����  U: ����  L: ���  X: ����");
					String protocol = br.readLine();
					if (protocol.equals("R") || protocol.equals("r")) { // ���
						register.registerProcess();
					} else if (protocol.equals("S") || protocol.equals("s")) { // �˻�
						search.searchProcess();
					} else if (protocol.equals("D") || protocol.equals("d")) { // ����
						delete.deleteProcess();
					} else if (protocol.equals("U") || protocol.equals("u")) { // ����
						update.updatePorcess();
					} else if (protocol.equals("L") || protocol.equals("l")) { // ��ü���, ���
						list.listPorcess();
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
