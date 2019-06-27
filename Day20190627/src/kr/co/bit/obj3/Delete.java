package kr.co.bit.obj3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
	private int select;
	private Scanner input;
	private String deleteName;
	private Connection conn;
	private Statement stmt;

	private String sql; // ������
	private int cnt; // stmt.executeUpdate(sql) ��� ���� �Լ�

	public Delete() {
		select = 0;
		input = new Scanner(System.in);
		stmt = null;

		sql = null;
		cnt = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // �ε�
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl"); // ����
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteProcess() {
		System.out.println("1.�л����� 2.�������� 3.�����ڻ���");
		select = input.nextInt();
		System.out.print("������ �̸� �Է� --> ");
		deleteName = input.next();

		if (select == 1) { // �л�����
			try {
				stmt = conn.createStatement();
				sql = "DELETE FROM student WHERE student.name = '" + deleteName + "'";
				cnt = stmt.executeUpdate(sql);
				if (cnt == 0) {
					System.out.println("�л� ���� ����");
				} else {
					System.out.println(cnt + "���� �л��� ���� �Ǿ����ϴ�.");
				}
				stmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (select == 2) { // ��������
			try {
				stmt = conn.createStatement();
				sql = "DELETE FROM professor WHERE professor.name = '" + deleteName + "'";
				cnt = stmt.executeUpdate(sql);
				if (cnt == 0) {
					System.out.println("���� ���� ����");
				} else {
					System.out.println(cnt + "���� ������ ���� �Ǿ����ϴ�.");
				}
				stmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 3) { // �����ڻ���
			try {
				stmt = conn.createStatement();
				sql = "DELETE FROM manager WHERE manager.name = '" + deleteName + "'";
				cnt = stmt.executeUpdate(sql);
				if (cnt == 0) {
					System.out.println("������ ���� ����");
				} else {
					System.out.println(cnt + "���� �����ڰ� ���� �Ǿ����ϴ�.");
				}
				stmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
