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
		System.out.println("1.학생삭제 2.교수삭제 3.관리자삭제");
		select = input.nextInt();
		System.out.print("삭제할 이름 입력 --> ");
		deleteName = input.next();

		if (select == 1) { // 학생삭제
			try {
				pstmt = conn.prepareStatement(sql);
				sql = "DELETE FROM student WHERE student.name = ?";
				pstmt.setString(1, deleteName);
				
				cnt = pstmt.executeUpdate();
				if (cnt == 0) {
					System.out.println("학생 삭제 실패");
				} else {
					System.out.println(cnt + "건의 학생이 삭제 되었습니다.");
				}
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (select == 2) { // 교수삭제
			try {
				pstmt = conn.prepareStatement(sql);
				sql = "DELETE FROM professor WHERE professor.name = ?";
				pstmt.setString(1, deleteName);
				
				cnt = pstmt.executeUpdate();
				if (cnt == 0) {
					System.out.println("교수 삭제 실패");
				} else {
					System.out.println(cnt + "건의 교수가 삭제 되었습니다.");
				}
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 3) { // 관리자삭제
			try {
				pstmt = conn.prepareStatement(sql);
				sql = "DELETE FROM manager WHERE manager.name = ?";
				pstmt.setString(1, deleteName);
				
				cnt = pstmt.executeUpdate();
				if (cnt == 0) {
					System.out.println("관리자 삭제 실패");
				} else {
					System.out.println(cnt + "건의 관리자가 삭제 되었습니다.");
				}
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
