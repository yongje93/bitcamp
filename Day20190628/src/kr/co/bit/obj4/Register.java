package kr.co.bit.obj4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Register {
	private int protocol;

	private Scanner input;
	private PreparedStatement pstmt;

	private int no; // ��ȣ
	private String age; // ����
	private String name; // �̸�
	private String hakbun; // �й�
	private String subject; // ����
	private String part; // �μ�

	private String sql; // ������
	private int cnt; // pstmt.executeUpdate() ��� ���� �Լ�

	public Register() {
		protocol = 0;
		pstmt = null;
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

			try {
				pstmt = conn.prepareStatement(sql);
				sql = "INSERT INTO student (no, age, name, hakbun) VALUES (?, ?, ?, ?)";
				pstmt.setInt(1, no);
				pstmt.setString(2, age);
				pstmt.setString(3, name);
				pstmt.setString(4, hakbun);
				
				cnt = pstmt.executeUpdate(); // sql�� �ʿ����.
				if (cnt == 0) {
					System.out.println("�л� ��� ����");
				} else {
					System.out.println(cnt + "���� �л��� ��� �Ǿ����ϴ�.");
				}
				pstmt.close();
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
				pstmt = conn.prepareStatement(sql);
				sql = "INSERT INTO professor (no, age, name, subject) VALUES (?, ?, ?, ?)";
				pstmt.setInt(1, no);
				pstmt.setString(2, age);
				pstmt.setString(3, name);
				pstmt.setString(4, subject);
				
				cnt = pstmt.executeUpdate();
				if (cnt == 0) {
					System.out.println("���� ��� ����");
				} else {
					System.out.println(cnt + "���� ������ ��� �Ǿ����ϴ�.");
				}
				pstmt.close();
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
				pstmt = conn.prepareStatement(sql);
				sql = "INSERT INTO manager (no, age, name, part) VALUES (?, ?, ?, ?)";
				pstmt.setInt(1, no);
				pstmt.setString(2, age);
				pstmt.setString(3, name);
				pstmt.setString(4, part);

				cnt = pstmt.executeUpdate();
				if (cnt == 0) {
					System.out.println("������ ��� ����");
				} else {
					System.out.println(cnt + "���� �����ڰ� ��� �Ǿ����ϴ�.");
				}
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
