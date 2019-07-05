package kr.co.bit.obj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class MemberShipMain_error {
	private static String session;

	static {
		session = null;
	}

	public static void main(String[] args) throws SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		String id = null;
		String passwd = null;
		String address = null;
		String tel = null;

		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			while (true) {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");

				if (conn == null) {
					System.out.println("�����ͺ��̽� ���� ����");
				} else {
					System.out.println("�����ͺ��̽� ���� ����");
				}

				System.out.println("R: ȸ������  L: ȸ�����  S: IDã��  D: ȸ��Ż��  E: ȸ������  I: �α���  O: �α׾ƿ�");
				String protocol = br.readLine();
				if (protocol.equals("R") | protocol.equals("r")) { // ȸ������
					if (session != null) {
						System.out.println("�α������Դϴ�.");
						continue;
					}
					System.out.print("���̵� �Է�: ");
					id = br.readLine();
					System.out.print("�н����� �Է�: ");
					passwd = br.readLine();
					System.out.print("�ּ� �Է�: ");
					address = br.readLine();
					System.out.print("��ȭ��ȣ �Է�: ");
					tel = br.readLine();

					sql = "INSERT INTO MEMBER (ID, PASSWD, ADDRESS, TEL) VALUES (?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, passwd);
					pstmt.setString(3, address);
					pstmt.setString(4, tel);
					int cnt = pstmt.executeUpdate();
					if (cnt == 0) {
						System.out.println("ȸ����� ����");
					} else {
						System.out.println(cnt + "���� ȸ���� ��ϵǾ����ϴ�.");
					}
					pstmt.close();
					conn.close();

				} else if (protocol.equals("L") | protocol.equals("l")) { // ȸ�����
					System.out.println("��ü���");
					System.out.print("ȸ�����̵�\tȸ���н�����\tȸ���ּ�\tȸ����ȭ��ȣ\n");

					sql = "SELECT ID, PASSWD, ADDRESS, TEL FROM MEMBER ORDER BY ID ASC";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						id = rs.getString("id");
						passwd = rs.getString("passwd");
						address = rs.getString("address");
						tel = rs.getString("tel");
						System.out.print(id + "\t" + passwd + "\t\t" + address + "\t" + tel + "\n");
					}
					rs.close();
					pstmt.close();
					conn.close();
					
				} else if (protocol.equals("S") | protocol.equals("s")) { // ȸ��ã��
					System.out.print("ã�� ���̵� �Է�: ");
					id = br.readLine();

					sql = "SELECT id, passwd, address, tel FROM MEMBER WHERE ID = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();

					System.out.print("ȸ�����̵�\tȸ���н�����\tȸ���ּ�\tȸ����ȭ��ȣ\n");
					while (rs.next()) {
						id = rs.getString("id");
						passwd = rs.getString("passwd");
						address = rs.getString("address");
						tel = rs.getString("tel");
						System.out.print(id + "\t" + passwd + "\t\t" + address + "\t" + tel + "\n");
					}
					rs.close();
					pstmt.close();
					conn.close();
					
				} else if (protocol.equals("D") | protocol.equals("d")) { // ȸ��Ż��
					if (session == null) {
						System.out.println("�α����ϼ���.");
						continue;
					}

					sql = "DELETE FROM MEMBER WHERE ID = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, session);
					int cnt = pstmt.executeUpdate();
					if (cnt == 0) {
						System.out.println("ȸ��Ż�� ����");
					} else {
						System.out.println(cnt + "���� ȸ���� Ż��Ǿ����ϴ�.");
					}
					session = null;

					pstmt.close();
					conn.close();

				} else if (protocol.equals("E") | protocol.equals("e")) { // ȸ������
					if (session == null) {
						System.out.println("�α����ϼ���.");
						continue;
					}
					sql = "SELECT id, passwd, address, tel FROM MEMBER WHERE ID = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, session);
					rs = pstmt.executeQuery();

					while (rs.next()) {
						id = rs.getString("id");
						passwd = rs.getString("passwd");
						address = rs.getString("address");
						tel = rs.getString("tel");
						System.out.print(id + "\t" + passwd + "\t\t" + address + "\t" + tel + "\n");
					}

					System.out.print("���̵� �Է�: ");
					id = br.readLine();
					System.out.print("�н����� �Է�: ");
					passwd = br.readLine();
					System.out.print("�ּ� �Է�: ");
					address = br.readLine();
					System.out.print("��ȭ��ȣ �Է�: ");
					tel = br.readLine();

					sql = "UPDATE MEMBER SET ID = ?, PASSWD = ?, ADDRESS = ?, TEL = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, passwd);
					pstmt.setString(3, address);
					pstmt.setString(4, tel);
					int cnt = pstmt.executeUpdate();
					if (cnt == 0) {
						System.out.println("ȸ������ ����");
					} else {
						System.out.println(cnt + "���� ȸ���� �����Ǿ����ϴ�.");
					}
					pstmt.close();
					conn.close();
					
				} else if (protocol.equals("I") | protocol.equals("i")) { // �α���
					System.out.print("���̵� �Է�: ");
					id = br.readLine();
					System.out.print("�н����� �Է�: ");
					passwd = br.readLine();

					sql = "select id, passwd from member where id = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						if (rs.getString("id").equals(id) && rs.getString("passwd").equals(passwd)) {
							System.out.println("ȯ���մϴ�. �α��� �Ǿ����ϴ�.");
							session = id;
						} else if (!rs.getString("id").equals(id) && rs.getString("passwd").equals(passwd)) {
							System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
							return;
						} else if (rs.getString("id").equals(id) && !rs.getString("passwd").equals(passwd)) {
							System.out.println("�н����尡 Ʋ�Ƚ��ϴ�.");
							return;
						} else if (!rs.getString("id").equals(id) && !rs.getString("passwd").equals(passwd)) {
							System.out.println("���̵�,�н����� �� �� Ʋ�Ƚ��ϴ�.");
							return;
						}
					}
					rs.close();
					pstmt.close();
					conn.close();
					
				} else if (protocol.equals("O") | protocol.equals("o")) { // �α׾ƿ�
					if (session == null) {
						System.out.println("�α����ϼ���.");
						continue;
					}
					System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
					session = null;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
