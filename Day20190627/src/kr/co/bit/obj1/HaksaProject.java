package kr.co.bit.obj1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class HaksaProject {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Connection conn = null;
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
				HaksaFunction.register(protocol, input, conn);
				if (protocol == 4) { // �����޴�
					System.out.println("�����޴�");
					continue;
				}
				
			} else if (protocol == 2) { // ã��
				HaksaFunction.search(input, conn);

			} else if (protocol == 3) { // ����
				HaksaFunction.delete(input, conn);

			} else if (protocol == 4) { // ��ü���
				HaksaFunction.list(input, conn);

			} else if (protocol == 0) { // ����
				System.out.println("����");
				System.exit(0);
			}
		}
	}

}
