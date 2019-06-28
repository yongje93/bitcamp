package kr.co.bit.obj3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Register {
	private int protocol;
	
	private Scanner input;
	private Statement stmt;
	
	private int no; 		// ��ȣ
	private String age; 	// ����
	private String name;	// �̸�
	private String hakbun; 	// �й�
	private String subject; // ����
	private String part; 	// �μ�

	private String sql; 	// ������
	private int cnt; 		// stmt.executeUpdate(sql) ��� ���� �Լ�

	public Register() {
		protocol = 0;
		stmt = null;
		no = 0;
		age = null;
		name = null;
		hakbun = null;
		
		input = new Scanner(System.in);
		sql = null;
		cnt = 0;
	}

	public void setProtocol() {
		System.out.println("====��ϸ޴�====");
		System.out.println("1.�л�");
		System.out.println("2.����");
		System.out.println("3.������");
		System.out.println("4.�����޴�");
		System.out.print("�޴� ����--> ");
		protocol = input.nextInt();
	}

	public void registerProcess(Connection conn) { // ��� �Լ�.
		setProtocol();
		if (protocol == 1) { // �л� ���
			System.out.print("��ȣ : ");
			no = input.nextInt();
			System.out.print("���� : ");
			age = input.next();
			System.out.print("�̸� : ");
			name = input.next();
			System.out.print("�й� : ");
			hakbun = input.next();

			// 3.�غ� 3-1 ���� �غ� 3-2 �����غ�
			try {
				stmt = conn.createStatement();	// DB�� ������ �� �� �ִ� ������ ����.
				sql = "INSERT INTO student (no, age, name, hakbun) VALUES (" + no + ", '" + age + "', '" + name + "', '"
						+ hakbun + "')";
				// 4. ���� executeUpdate(sql) -> ���, ����, ���� // executeQuery(sql) -> �˻�, ���
				//	 										  (ResultSet ���·� ��ȯ��.)
				cnt = stmt.executeUpdate(sql);

				if (cnt == 0) {
					System.out.println("�л� ��� ����");
				} else {
					System.out.println(cnt + "���� �л��� ��� �Ǿ����ϴ�.");
				}
				// 5.����
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (protocol == 2) { // ���� ���
			System.out.print("��ȣ : ");
			no = input.nextInt();
			System.out.print("���� : ");
			age = input.next();
			System.out.print("�̸� : ");
			name = input.next();
			System.out.print("���� : ");
			subject = input.next();

			try {
				stmt = conn.createStatement();
				sql = "INSERT INTO professor (no, age, name, subject) VALUES (" + no + ", '" + age + "', '" + name
						+ "', '" + subject + "')";
				cnt = stmt.executeUpdate(sql);

				if (cnt == 0) {
					System.out.println("���� ��� ����");
				} else {
					System.out.println(cnt + "���� ������ ��� �Ǿ����ϴ�.");
				}
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (protocol == 3) { // ������ ���
			System.out.print("��ȣ : ");
			no = input.nextInt();
			System.out.print("���� : ");
			age = input.next();
			System.out.print("�̸� : ");
			name = input.next();
			System.out.print("�μ� : ");
			part = input.next();

			try {
				stmt = conn.createStatement();
				sql = "INSERT INTO manager (no, age, name, part) VALUES (" + no + ", '" + age + "', '" + name + "', '"
						+ part + "')";
				cnt = stmt.executeUpdate(sql);
				if (cnt == 0) {
					System.out.println("������ ��� ����");
				} else {
					System.out.println(cnt + "���� �����ڰ� ��� �Ǿ����ϴ�.");
				}
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
