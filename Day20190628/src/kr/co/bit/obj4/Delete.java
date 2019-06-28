package kr.co.bit.obj4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
	private int select;
	private String deleteName;
	private PreparedStatement pstmt;
	
	private Scanner input;
	private String sql;
	private int cnt; 

	public Delete() {
		select = 0;
		pstmt = null;
		
		input = new Scanner(System.in);
		sql = null;
		cnt = 0;
	}

	public void deleteProcess(Connection conn) {
		System.out.println("1.�л����� 2.�������� 3.�����ڻ���");
		select = input.nextInt();
		System.out.print("������ �̸� �Է� --> ");
		deleteName = input.next();

		if (select == 1) { // �л�����
			try {
				pstmt = conn.prepareStatement(sql);
				sql = "DELETE FROM student WHERE student.name = ?";
				pstmt.setString(1, deleteName);
				
				cnt = pstmt.executeUpdate();
				if (cnt == 0) {
					System.out.println("�л� ���� ����");
				} else {
					System.out.println(cnt + "���� �л��� ���� �Ǿ����ϴ�.");
				}
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (select == 2) { // ��������
			try {
				pstmt = conn.prepareStatement(sql);
				sql = "DELETE FROM professor WHERE professor.name = ?";
				pstmt.setString(1, deleteName);
				
				cnt = pstmt.executeUpdate();
				if (cnt == 0) {
					System.out.println("���� ���� ����");
				} else {
					System.out.println(cnt + "���� ������ ���� �Ǿ����ϴ�.");
				}
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 3) { // �����ڻ���
			try {
				pstmt = conn.prepareStatement(sql);
				sql = "DELETE FROM manager WHERE manager.name = ?";
				pstmt.setString(1, deleteName);
				
				cnt = pstmt.executeUpdate();
				if (cnt == 0) {
					System.out.println("������ ���� ����");
				} else {
					System.out.println(cnt + "���� �����ڰ� ���� �Ǿ����ϴ�.");
				}
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
