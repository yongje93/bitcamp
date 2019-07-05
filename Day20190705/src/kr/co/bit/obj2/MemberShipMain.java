package kr.co.bit.obj2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class MemberShipMain {
	public static String session;

	static {
		session = null;
	}

	public static void main(String[] args) throws SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Connection conn = null;
		Register register = new Register();
		List list = new List();
		Search search = new Search();
		Delete delete = new Delete();
		Edit edit = new Edit();
		Login login = new Login();
		Logout logout = new Logout();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			while (true) {
				conn = MemberShip.getConnection();
				if (conn == null) {
					System.out.println("�����ͺ��̽� ���� ����");
				} else {
					System.out.println("�����ͺ��̽� ���� ����");
				}
				System.out.println("R: ȸ������  L: ȸ�����  S: IDã��  D: ȸ��Ż��  E: ȸ������  I: �α���  O: �α׾ƿ�");
				String protocol = br.readLine();
				if (protocol.equals("R") | protocol.equals("r")) { // ȸ������
					register.registerProcess();
				} else if (protocol.equals("L") | protocol.equals("l")) { // ȸ�����
					list.listProcess();
				} else if (protocol.equals("S") | protocol.equals("s")) { // ȸ��ã��
					search.searchProcess();
				} else if (protocol.equals("D") | protocol.equals("d")) { // ȸ��Ż��
					delete.deleteProcess();
				} else if (protocol.equals("E") | protocol.equals("e")) { // ȸ������
					edit.editProcess();
				} else if (protocol.equals("I") | protocol.equals("i")) { // �α���
					login.loginProcess();
				} else if (protocol.equals("O") | protocol.equals("o")) { // �α׾ƿ�
					logout.logoutProcess();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
