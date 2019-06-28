package kr.co.bit.obj4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class HaksaProject {

	public static void main(String[] args) {
		Connection conn = null;
		Scanner input = new Scanner(System.in);
		Register register = new Register();
		Search search = new Search();
		Delete delete = new Delete();
		List list = new List();
		
		while (true) {
			try {
				// 1. �ε�(����) - �ڹٿ��� �����ͺ��̽� ����Ŭ�� ����Ѵ�.
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// 2. ���� Connection DriverManager
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
				if (conn == null) {
					System.out.println("�����ͺ��̽� ���� ����");
				} else {
					System.out.println("�����ͺ��̽� ���� ����");
				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			System.out.println("�л����");
			System.out.println("====�޴�====");
			System.out.println("1.���\n2.ã��\n3.����\n4.��ü���");
			System.out.println("===========");
			System.out.println("0.����");
			System.out.print("�޴� ����--> ");

			int protocol = input.nextInt();
			if (protocol == 1) { // ���
				register.registerProcess(conn);
				if (protocol == 4) { // �����޴�
					System.out.println("�����޴�");
					continue;
				}
			} else if (protocol == 2) { // ã��
				search.searchProcess(conn);
			} else if (protocol == 3) { // ����
				delete.deleteProcess(conn);
			} else if (protocol == 4) { // ��ü���
				list.listProcess(conn);
			} else if (protocol == 0) { // ����
				System.out.println("����");
				System.exit(0);
			}
		}
	}

}
