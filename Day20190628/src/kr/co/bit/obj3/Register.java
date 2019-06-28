package kr.co.bit.obj3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Register {
	private int protocol;
	
	private Scanner input;
	private Statement stmt;
	
	private int no; 		// 번호
	private String age; 	// 나이
	private String name;	// 이름
	private String hakbun; 	// 학번
	private String subject; // 과목
	private String part; 	// 부서

	private String sql; 	// 쿼리문
	private int cnt; 		// stmt.executeUpdate(sql) 결과 갖는 함수

	public Register() {
		protocol = 0;
		stmt = null;
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

			// 3.준비 3-1 공간 준비 3-2 문장준비
			try {
				stmt = conn.createStatement();	// DB에 쿼리를 쓸 수 있는 공간을 만듬.
				sql = "INSERT INTO student (no, age, name, hakbun) VALUES (" + no + ", '" + age + "', '" + name + "', '"
						+ hakbun + "')";
				// 4. 실행 executeUpdate(sql) -> 등록, 삭제, 수정 // executeQuery(sql) -> 검색, 목록
				//	 										  (ResultSet 형태로 반환함.)
				cnt = stmt.executeUpdate(sql);

				if (cnt == 0) {
					System.out.println("학생 등록 실패");
				} else {
					System.out.println(cnt + "건의 학생이 등록 되었습니다.");
				}
				// 5.종료
				stmt.close();
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
				stmt = conn.createStatement();
				sql = "INSERT INTO professor (no, age, name, subject) VALUES (" + no + ", '" + age + "', '" + name
						+ "', '" + subject + "')";
				cnt = stmt.executeUpdate(sql);

				if (cnt == 0) {
					System.out.println("교수 등록 실패");
				} else {
					System.out.println(cnt + "건의 교수가 등록 되었습니다.");
				}
				stmt.close();
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
				stmt = conn.createStatement();
				sql = "INSERT INTO manager (no, age, name, part) VALUES (" + no + ", '" + age + "', '" + name + "', '"
						+ part + "')";
				cnt = stmt.executeUpdate(sql);
				if (cnt == 0) {
					System.out.println("관리자 등록 실패");
				} else {
					System.out.println(cnt + "건의 관리자가 등록 되었습니다.");
				}
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
