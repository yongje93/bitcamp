package kr.co.bit.obj3;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
	private int select;
	private String deleteName;
	private Statement stmt;
	
	private Scanner input;

	private String sql; // 쿼리문
	private int cnt; // stmt.executeUpdate(sql) 결과 갖는 함수

	public Delete() {
		select = 0;
		stmt = null;
		
		input = new Scanner(System.in);
		sql = null;
		cnt = 0;
	}

	public void deleteProcess(Connection conn) {
		System.out.println("1.학생삭제 2.교수삭제 3.관리자삭제");
		select = input.nextInt();
		System.out.print("삭제할 이름 입력 --> ");
		deleteName = input.next();

		if (select == 1) { // 학생삭제
			try {
				stmt = conn.createStatement();
				sql = "DELETE FROM student WHERE student.name = '" + deleteName + "'";
				cnt = stmt.executeUpdate(sql);
				if (cnt == 0) {
					System.out.println("학생 삭제 실패");
				} else {
					System.out.println(cnt + "건의 학생이 삭제 되었습니다.");
				}
				stmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (select == 2) { // 교수삭제
			try {
				stmt = conn.createStatement();
				sql = "DELETE FROM professor WHERE professor.name = '" + deleteName + "'";
				cnt = stmt.executeUpdate(sql);
				if (cnt == 0) {
					System.out.println("교수 삭제 실패");
				} else {
					System.out.println(cnt + "건의 교수가 삭제 되었습니다.");
				}
				stmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 3) { // 관리자삭제
			try {
				stmt = conn.createStatement();
				sql = "DELETE FROM manager WHERE manager.name = '" + deleteName + "'";
				cnt = stmt.executeUpdate(sql);
				if (cnt == 0) {
					System.out.println("관리자 삭제 실패");
				} else {
					System.out.println(cnt + "건의 관리자가 삭제 되었습니다.");
				}
				stmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
