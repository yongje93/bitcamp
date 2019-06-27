package kr.co.bit.obj3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Search {
	private int select; // �л�, ����, ������ ��å
	private Scanner input;
	private String findName; // ã���� �ϴ� �̸�.
	private Connection conn;
	private Statement stmt;
	private ResultSet rs; // ���̺��� ù��° ���� ����Ŵ. �ʱ�ȭ�� null�� ����.

	private int no; // ��ȣ
	private String age; // ����
	private String name; // �̸�
	private String hakbun; // �й�
	private String subject; // ����
	private String part; // �μ�

	private String sql; // ������

	public Search() {
		select = 0;
		findName = null;
		input = new Scanner(System.in);
		stmt = null;
		no = 0;
		age = null;
		name = null;
		hakbun = null;

		sql = null;
		rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // �ε�
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl"); // ����
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void searchProcess() {
		System.out.println("1.�л�ã�� 2.����ã�� 3.������ã��");
		select = input.nextInt();
		System.out.print("ã�� �̸� �Է� --> ");
		findName = input.next();

		if (select == 1) { // �л�ã��
			try {
				stmt = conn.createStatement();
				sql = "SELECT no, age, name, hakbun FROM student WHERE name = '" + findName + "'";
				rs = stmt.executeQuery(sql);

				System.out.print("��ȣ\t����\t�̸�\t�й�\n");
				while (rs.next()) {
					no = rs.getInt("no");
					age = rs.getString("age");
					name = rs.getString("name");
					hakbun = rs.getString("hakbun");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + hakbun + "\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 2) { // ����ã��
			try {
				stmt = conn.createStatement();
				sql = "SELECT no, age, name, subject FROM professor WHERE name = '" + findName + "'";
				rs = stmt.executeQuery(sql);

				System.out.print("��ȣ\t����\t�̸�\t����\n");
				while (rs.next()) {
					no = rs.getInt("no");
					age = rs.getString("age");
					name = rs.getString("name");
					subject = rs.getString("subject");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + subject + "\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 3) { // ������ã��
			try {
				stmt = conn.createStatement();
				sql = "SELECT no, age, name, part FROM manager WHERE name = '" + findName + "'";
				rs = stmt.executeQuery(sql);

				System.out.print("��ȣ\t����\t�̸�\t�μ�\n");
				while (rs.next()) {
					no = rs.getInt("no");
					age = rs.getString("age");
					name = rs.getString("name");
					part = rs.getString("part");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + part + "\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
