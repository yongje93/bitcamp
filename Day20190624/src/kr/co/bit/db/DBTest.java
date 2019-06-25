package kr.co.bit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBTest {

	public static void main(String[] args) {
		// 1. �ε�(����) - �ڹٿ��� ����Ŭ ����Ѵٰ� �˷��ֱ�.
		// 2. ����(Connection) (url(���),���̵�,�н�����)
		// 3. �غ�(Statement) 3-1 �����غ�
		// 					 3-2 �����غ�
		// 4. ����(execute) 1) executeUpdate(); - ���, ����, ����
		// 				   2) executeQuery(); - �˻�, ���
		// 5. ����(conn.close, stmt.close)
		Scanner input = new Scanner(System.in);

		try {
			while (true) {
				Class.forName("oracle.jdbc.dirver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
				System.out.println("1.��� 2.���� 3.��ü��� 4.�˻�");
				int protocol = input.nextInt();

				if (conn == null) {
					System.out.println("�����ͺ��̽� ���� ����");
				} else if (protocol == 1) {	//���
					System.out.println("�����ͺ��̽� ���� ����");
					System.out.println("�л����");

					System.out.print("��ȣ�Է�: ");
					int no = input.nextInt();
					System.out.print("���� : ");
					String age = input.next();
					System.out.print("�̸�: ");
					String name = input.next();
					System.out.print("�й�: ");
					String hakbun = input.next();

					Statement stmt = conn.createStatement(); // �����غ�
					String sql = "insert into student(no, age, name, hakbun) values (" + no + ",'" + age + "','" + name
							+ "','" + hakbun + "')"; // �����غ�
					int cnt = stmt.executeUpdate(sql); // ����
					if (cnt == 0) {
						System.out.println("����� ���� �Ǿ����ϴ�.");
					} else {
						System.out.println(cnt + "�� �л��� ��� �Ǿ����ϴ�.");
						conn.close();	//����
						stmt.close();	//����
					}
				} else if (protocol == 2) {	//����
					System.out.println("�л� ����");
					System.out.print("������ �̸� �Է�: ");
					String deleteName = input.next();

					Statement stmt = conn.createStatement(); // �����غ�
					String sql = "DELETE FROM student WHERE name = '" + deleteName + "'"; // �����غ�
					int cnt = stmt.executeUpdate(sql);	//����
					if (cnt == 0) {
						System.out.println("�л� ���� ����");
					} else {
						System.out.println(cnt + "�� �л� ���� ����");
						conn.close(); 	//����
						stmt.close(); 	//����
					}
				} else if (protocol == 3) {	//��ü���
					System.out.println("��ü ���");
					System.out.print("��ȣ\t����\t�̸�\t�й�\n");
					Statement stmt = conn.createStatement(); // �����غ�
					String sql = "SELECT no, age, name, hakbun FROM student ORDER BY NO ASC";	//�����غ�
					ResultSet rs = stmt.executeQuery(sql);	//����
					
					while (rs.next()) {
						int no = rs.getInt("no");
						String age = rs.getString("age");
						String name = rs.getString("name");
						String hakbun = rs.getString("hakbun");
						System.out.println(no+"\t"+age+"\t"+name+"\t"+hakbun);
					}
					conn.close();	//����
					stmt.close();	//����
					
				} else if (protocol == 4) {
					System.out.print("�˻��� �̸� �Է�: ");
					String searchName = input.next();
					System.out.print("��ȣ\t����\t�̸�\t�й�\n");
					Statement stmt = conn.createStatement(); // �����غ�
					String sql = "SELECT no, age, name, hakbun FROM student WHERE name = '" + searchName + "'";	//�����غ�
					ResultSet rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						int no = rs.getInt("no");
						String age = rs.getString("age");
						String name = rs.getString("name");
						String hakbun = rs.getString("hakbun");
						System.out.println(no+"\t"+age+"\t"+name+"\t"+hakbun);
					}
					conn.close();	//����
					stmt.close();	//����
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
