package kr.co.bit.obj4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Register {
	private int protocol;

	private Scanner input;
	private PreparedStatement pstmt;

	private int no; // 번호
	private String age; // 나이
	private String name; // 이름
	private String hakbun; // 학번
	private String subject; // 과목
	private String part; // 부서

	private String sql; // 쿼리문
	private int cnt; // pstmt.executeUpdate() 결과 갖는 함수

	public Register() {
		protocol = 0;
		pstmt = null;
		no = 0;
		age = null;
		name = null;
		hakbun = null;

		input = new Scanner(System.in);
		sql = null;
		cnt = 0;
	}

	public void setProtocol() {
		System.out.println("====등록메뉴====");
		System.out.println("1.학생");
		System.out.println("2.교수");
		System.out.println("3.관리자");
		System.out.println("4.이전메뉴");
		System.out.print("메뉴 선택--> ");
		protocol = input.nextInt();
	}

	public void registerProcess(Connection conn) { // 등록 함수.
		setProtocol();
		if (protocol == 1) { // 학생 등록
			System.out.print("번호 : ");
			no = input.nextInt();
			System.out.print("나이 : ");
			age = input.next();
			System.out.print("이름 : ");
			name = input.next();
			System.out.print("학번 : ");
			hakbun = input.next();

			try {
				pstmt = conn.prepareStatement(sql);
				sql = "INSERT INTO student (no, age, name, hakbun) VALUES (?, ?, ?, ?)";
				pstmt.setInt(1, no);
				pstmt.setString(2, age);
				pstmt.setString(3, name);
				pstmt.setString(4, hakbun);
				
				cnt = pstmt.executeUpdate(); // sql문 필요없음.
				if (cnt == 0) {
					System.out.println("학생 등록 실패");
				} else {
					System.out.println(cnt + "건의 학생이 등록 되었습니다.");
				}
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (protocol == 2) { // 교수 등록
			System.out.print("번호 : ");
			no = input.nextInt();
			System.out.print("나이 : ");
			age = input.next();
			System.out.print("이름 : ");
			name = input.next();
			System.out.print("과목 : ");
			subject = input.next();

			try {
				pstmt = conn.prepareStatement(sql);
				sql = "INSERT INTO professor (no, age, name, subject) VALUES (?, ?, ?, ?)";
				pstmt.setInt(1, no);
				pstmt.setString(2, age);
				pstmt.setString(3, name);
				pstmt.setString(4, subject);
				
				cnt = pstmt.executeUpdate();
				if (cnt == 0) {
					System.out.println("교수 등록 실패");
				} else {
					System.out.println(cnt + "건의 교수가 등록 되었습니다.");
				}
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (protocol == 3) { // 관리자 등록
			System.out.print("번호 : ");
			no = input.nextInt();
			System.out.print("나이 : ");
			age = input.next();
			System.out.print("이름 : ");
			name = input.next();
			System.out.print("부서 : ");
			part = input.next();

			try {
				pstmt = conn.prepareStatement(sql);
				sql = "INSERT INTO manager (no, age, name, part) VALUES (?, ?, ?, ?)";
				pstmt.setInt(1, no);
				pstmt.setString(2, age);
				pstmt.setString(3, name);
				pstmt.setString(4, part);

				cnt = pstmt.executeUpdate();
				if (cnt == 0) {
					System.out.println("관리자 등록 실패");
				} else {
					System.out.println(cnt + "건의 관리자가 등록 되었습니다.");
				}
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
