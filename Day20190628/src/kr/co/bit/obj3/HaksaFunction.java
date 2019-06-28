package kr.co.bit.obj3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HaksaFunction {
	public void register(int protocol, Scanner input, Connection conn) {	// ��� �Լ�.
		System.out.println("====��ϸ޴�====");
		System.out.println("1.�л�");
		System.out.println("2.����");
		System.out.println("3.������");
		System.out.println("4.�����޴�");
		System.out.print("�޴� ����--> ");
		protocol = input.nextInt();

		if (protocol == 1) { // �л� ���
			System.out.print("��ȣ : ");
			int no = input.nextInt();
			System.out.print("���� : ");
			String age = input.next();
			System.out.print("�̸� : ");
			String name = input.next();
			System.out.print("�й� : ");
			String hakbun = input.next();

			// 3.�غ� 3-1 ���� �غ� 3-2 �����غ�
			try {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO student (no, age, name, hakbun) VALUES (" + no + ", '" + age + "', '" + name
						+ "', '" + hakbun + "')";
				// 4. ���� executeUpdate(sql) -> ���, ����, ���� // executeQuery(sql) -> �˻�, ���
				// (ResultSet ���·� ��ȯ��.)
				int cnt = stmt.executeUpdate(sql);

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
			int no = input.nextInt();
			System.out.print("���� : ");
			String age = input.next();
			System.out.print("�̸� : ");
			String name = input.next();
			System.out.print("���� : ");
			String subject = input.next();

			try {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO professor (no, age, name, subject) VALUES (" + no + ", '" + age + "', '"
						+ name + "', '" + subject + "')";
				int cnt = stmt.executeUpdate(sql);

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
			int no = input.nextInt();
			System.out.print("���� : ");
			String age = input.next();
			System.out.print("�̸� : ");
			String name = input.next();
			System.out.print("�μ� : ");
			String part = input.next();

			try {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO manager (no, age, name, part) VALUES (" + no + ", '" + age + "', '" + name
						+ "', '" + part + "')";
				int cnt = stmt.executeUpdate(sql);
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

	public void search(Scanner input, Connection conn) {
		System.out.println("1.�л�ã�� 2.����ã�� 3.������ã��");
		int select = input.nextInt();
		System.out.print("ã�� �̸� �Է� --> ");
		String findName = input.next();

		if (select == 1) { // �л�ã��
			try {
				Statement stmt = conn.createStatement();
				String sql = "SELECT no, age, name, hakbun FROM student WHERE name = '" + findName + "'";
				ResultSet rs = stmt.executeQuery(sql);

				System.out.print("��ȣ\t����\t�̸�\t�й�\n");
				while (rs.next()) {
					int no = rs.getInt("no");
					String age = rs.getString("age");
					String name = rs.getString("name");
					String hakbun = rs.getString("hakbun");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + hakbun + "\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 2) { // ����ã��
			try {
				Statement stmt = conn.createStatement();
				String sql = "SELECT no, age, name, subject FROM professor WHERE name = '" + findName + "'";
				ResultSet rs = stmt.executeQuery(sql);

				System.out.print("��ȣ\t����\t�̸�\t����\n");
				while (rs.next()) {
					int no = rs.getInt("no");
					String age = rs.getString("age");
					String name = rs.getString("name");
					String subject = rs.getString("subject");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + subject + "\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 3) { // ������ã��
			try {
				Statement stmt = conn.createStatement();
				String sql = "SELECT no, age, name, part FROM manager WHERE name = '" + findName + "'";
				ResultSet rs = stmt.executeQuery(sql);

				System.out.print("��ȣ\t����\t�̸�\t�μ�\n");
				while (rs.next()) {
					int no = rs.getInt("no");
					String age = rs.getString("age");
					String name = rs.getString("name");
					String part = rs.getString("part");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + part + "\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(Scanner input, Connection conn) {
		System.out.println("1.�л����� 2.�������� 3.�����ڻ���");
		int select = input.nextInt();
		System.out.print("������ �̸� �Է� --> ");
		String deleteName = input.next();

		if (select == 1) { // �л�����
			try {
				Statement stmt = conn.createStatement();
				String sql = "DELETE FROM student WHERE student.name = '" + deleteName + "'";
				int cnt = stmt.executeUpdate(sql);
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
				Statement stmt = conn.createStatement();
				String sql = "DELETE FROM professor WHERE professor.name = '" + deleteName + "'";
				int cnt = stmt.executeUpdate(sql);
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
				Statement stmt = conn.createStatement();
				String sql = "DELETE FROM manager WHERE manager.name = '" + deleteName + "'";
				int cnt = stmt.executeUpdate(sql);
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

	public void list(Scanner input, Connection conn) {
		System.out.println("��ü���");
		System.out.println("1.�л���ü��� 2.������ü��� 3.��������ü���");
		System.out.print("�޴� ����--> ");
		int select = input.nextInt();
		if (select == 1) { // �л���ü���
			try {
				System.out.print("��ȣ\t����\t�̸�\t�й�\n");
				Statement stmt = conn.createStatement();
				String sql = "SELECT no, age, name, hakbun FROM student ORDER BY no ASC";
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					int no = rs.getInt("no");
					String age = rs.getString("age");
					String name = rs.getString("name");
					String hakbun = rs.getString("hakbun");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + hakbun + "\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 2) { // ������ü���
			try {
				System.out.print("��ȣ\t����\t�̸�\t����\n");
				Statement stmt = conn.createStatement();
				String sql = "SELECT no, age, name, subject FROM professor ORDER BY no ASC";
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					int no = rs.getInt("no");
					String age = rs.getString("age");
					String name = rs.getString("name");
					String subject = rs.getString("subject");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + subject + "\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 3) { // ��������ü���
			try {
				System.out.print("��ȣ\t����\t�̸�\t�μ�\n");
				Statement stmt = conn.createStatement();
				String sql = "SELECT no, age, name, part FROM manager ORDER BY no ASC";
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					int no = rs.getInt("no");
					String age = rs.getString("age");
					String name = rs.getString("name");
					String part = rs.getString("part");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + part + "\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
