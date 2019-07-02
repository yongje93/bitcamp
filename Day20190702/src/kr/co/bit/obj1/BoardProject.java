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
		// 1.�ε� Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2.���� Connection conn = DriverManager.getConnection(url, id, pw);
		// 3.�غ�
		// 4.���� executeQuery(�˻�,��ü���) executeUpdate(���, ����, ����)
		// 5.����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Ű���� �Է� (Scanner ��ſ� ��)
		BoardFunction bf = new BoardFunction();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			while (true) {
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
				if (conn == null) {
					System.out.println("����Ŭ ���� ����");
				} else {
					System.out.println("����Ŭ ���� ����");

					System.out.println("====�Խ��� �ۼ�====");

					System.out.println("R: ���  S: �˻�  D: ����  U: ����  L: ���");
					String protocol = br.readLine();
					if (protocol.equals("R") || protocol.equals("r")) { // ���
						bf.register(br, conn);
					} else if (protocol.equals("S") || protocol.equals("s")) { // �˻�
						bf.search(br, conn);
					} else if (protocol.equals("D") || protocol.equals("d")) { // ����
						bf.delete(br, conn);
					} else if (protocol.equals("U") || protocol.equals("u")) { // ����
						bf.update(br, conn);
					} else if (protocol.equals("L") || protocol.equals("l")) { // ��ü���, ���
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
