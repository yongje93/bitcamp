package kr.co.bit.obj3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class List {
	private int select; // �л�, ����, ������ ��å
	private Scanner input;
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

	public List() {
		select = 0;
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
	
	
	public void listProcess() {
		System.out.println("��ü���");
		System.out.println("1.�л���ü��� 2.������ü��� 3.��������ü���");
		System.out.print("�޴� ����--> ");
		select = input.nextInt();
		if (select == 1) { // �л���ü���
			try {
				System.out.print("��ȣ\t����\t�̸�\t�й�\n");
				stmt = conn.createStatement();
				sql = "SELECT no, age, name, hakbun FROM student ORDER BY no ASC";
				rs = stmt.executeQuery(sql);

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
		} else if (select == 2) { // ������ü���
			try {
				System.out.print("��ȣ\t����\t�̸�\t����\n");
				stmt = conn.createStatement();
				sql = "SELECT no, age, name, subject FROM professor ORDER BY no ASC";
				rs = stmt.executeQuery(sql);

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
		} else if (select == 3) { // ��������ü���
			try {
				System.out.print("��ȣ\t����\t�̸�\t�μ�\n");
				stmt = conn.createStatement();
				sql = "SELECT no, age, name, part FROM manager ORDER BY no ASC";
				rs = stmt.executeQuery(sql);

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
