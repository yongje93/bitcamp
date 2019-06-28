package kr.co.bit.obj4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Search {
	private int select; // �л�, ����, ������ ��å
	private String findName; // ã���� �ϴ� �̸�.
	private PreparedStatement pstmt;
	private ResultSet rs; // ���̺��� ù��° ���� ����Ŵ. �ʱ�ȭ�� null�� ����.

	private int no; // ��ȣ
	private String age; // ����
	private String name; // �̸�
	private String hakbun; // �й�
	private String subject; // ����
	private String part; // �μ�

	private Scanner input;
	private String sql; // ������

	public Search() {
		select = 0;
		findName = null;
		pstmt = null;
		no = 0;
		age = null;
		name = null;
		hakbun = null;
		input = new Scanner(System.in);
		
		sql = null;
		rs = null;
	}

	public void searchProcess(Connection conn) {
		System.out.println("1.�л�ã�� 2.����ã�� 3.������ã��");
		select = input.nextInt();
		System.out.print("ã�� �̸� �Է� --> ");
		findName = input.next();

		if (select == 1) { // �л�ã��
			try {
				pstmt = conn.prepareStatement(sql);
				sql = "SELECT no, age, name, hakbun FROM student WHERE name = ?";
				pstmt.setString(1, findName);
				rs = pstmt.executeQuery();

				System.out.print("��ȣ\t����\t�̸�\t�й�\n");
				while (rs.next()) {
					no = rs.getInt("no");
					age = rs.getString("age");
					name = rs.getString("name");
					hakbun = rs.getString("hakbun");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + hakbun + "\n");
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 2) { // ����ã��
			try {
				pstmt = conn.prepareStatement(sql);
				sql = "SELECT no, age, name, subject FROM professor WHERE name = ?";
				pstmt.setString(1, findName);
				rs = pstmt.executeQuery();

				System.out.print("��ȣ\t����\t�̸�\t����\n");
				while (rs.next()) {
					no = rs.getInt("no");
					age = rs.getString("age");
					name = rs.getString("name");
					subject = rs.getString("subject");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + subject + "\n");
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 3) { // ������ã��
			try {
				pstmt = conn.prepareStatement(sql);
				sql = "SELECT no, age, name, part FROM manager WHERE name = ?";
				pstmt.setString(1, findName);
				rs = pstmt.executeQuery();

				System.out.print("��ȣ\t����\t�̸�\t�μ�\n");
				while (rs.next()) {
					no = rs.getInt("no");
					age = rs.getString("age");
					name = rs.getString("name");
					part = rs.getString("part");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + part + "\n");
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
