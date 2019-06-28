package kr.co.bit.obj3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class List {
	private int select; // �л�, ����, ������ ��å
	private Statement stmt;
	private ResultSet rs; // ���̺��� ù��° ���� ����Ŵ. �ʱ�ȭ�� null�� ����.

	private int no; // ��ȣ
	private String age; // ����
	private String name; // �̸�
	private String hakbun; // �й�
	private String subject; // ����
	private String part; // �μ�

	private String p_age; // ��ü��� ��������
	private String p_name; // ��ü��� �����̸�
	private String m_age; // ��ü��� �����ڳ���
	private String m_name; // ��ü��� �������̸�

	private Scanner input;
	private String sql; // ������

	public List() {
		select = 0;
		stmt = null;
		no = 0;
		age = null;
		name = null;
		hakbun = null;
		p_age = null;
		p_name = null;
		m_age = null;
		m_name = null;

		input = new Scanner(System.in);
		sql = null;
		rs = null;
	}

	public void listProcess(Connection conn) {
		System.out.println("��ü���");
		System.out.println("1.�л���ü��� 2.������ü��� 3.��������ü��� 4.�л���ü���");
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
				rs.close();
				stmt.close();
				conn.close();
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
				rs.close();
				stmt.close();
				conn.close();
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
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 4) { // �л� ��ü���
			try {
				System.out.print("��ȣ\t����\t�̸�\t�й�\t��������\t�����̸�\t����\t��������\t�����̸�\t�μ�\n");
				stmt = conn.createStatement();
				sql = "SELECT s.no as ��ȣ, s.age as ����, s.name as �̸�, s.hakbun as �й�, p.age as �������� , p.name as �����̸�, p.subject as ����, m.age as �����ڳ���, m.name as �������̸�, m.part as �μ� FROM (student s left join professor p on s.no = p. no) left join manager m on s.no = m.no ORDER BY ��ȣ ASC";
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					no = rs.getInt("��ȣ");
					age = rs.getString("����");
					name = rs.getString("�̸�");
					hakbun = rs.getString("�й�");
					p_age = rs.getString("��������");
					p_name = rs.getString("�����̸�");
					subject = rs.getString("����");
					m_age = rs.getString("�����ڳ���");
					m_name = rs.getString("�������̸�");
					part = rs.getString("�μ�");

					System.out.print(no + "\t" + age + "\t" + name + "\t" + hakbun + "\t" + p_age + "\t" + p_name + "\t"
							+ subject + "\t" + m_age + "\t" + m_name + "\t" + part + "\n");
				}
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
