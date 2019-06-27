package kr.co.bit.obj3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HaksaFunction {
	public void register(int protocol, Scanner input, Connection conn) {	// 등록 함수.
		System.out.println("====등록메뉴====");
		System.out.println("1.학생");
		System.out.println("2.교수");
		System.out.println("3.관리자");
		System.out.println("4.이전메뉴");
		System.out.print("메뉴 선택--> ");
		protocol = input.nextInt();

		if (protocol == 1) { // 학생 등록
			System.out.print("번호 : ");
			int no = input.nextInt();
			System.out.print("나이 : ");
			String age = input.next();
			System.out.print("이름 : ");
			String name = input.next();
			System.out.print("학번 : ");
			String hakbun = input.next();

			// 3.준비 3-1 공간 준비 3-2 문장준비
			try {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO student (no, age, name, hakbun) VALUES (" + no + ", '" + age + "', '" + name
						+ "', '" + hakbun + "')";
				// 4. 실행 executeUpdate(sql) -> 등록, 삭제, 수정 // executeQuery(sql) -> 검색, 목록
				// (ResultSet 형태로 반환함.)
				int cnt = stmt.executeUpdate(sql);

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
			int no = input.nextInt();
			System.out.print("나이 : ");
			String age = input.next();
			System.out.print("이름 : ");
			String name = input.next();
			System.out.print("과목 : ");
			String subject = input.next();

			try {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO professor (no, age, name, subject) VALUES (" + no + ", '" + age + "', '"
						+ name + "', '" + subject + "')";
				int cnt = stmt.executeUpdate(sql);

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
			int no = input.nextInt();
			System.out.print("나이 : ");
			String age = input.next();
			System.out.print("이름 : ");
			String name = input.next();
			System.out.print("부서 : ");
			String part = input.next();

			try {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO manager (no, age, name, part) VALUES (" + no + ", '" + age + "', '" + name
						+ "', '" + part + "')";
				int cnt = stmt.executeUpdate(sql);
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

	public void search(Scanner input, Connection conn) {
		System.out.println("1.학생찾기 2.교수찾기 3.관리자찾기");
		int select = input.nextInt();
		System.out.print("찾을 이름 입력 --> ");
		String findName = input.next();

		if (select == 1) { // 학생찾기
			try {
				Statement stmt = conn.createStatement();
				String sql = "SELECT no, age, name, hakbun FROM student WHERE name = '" + findName + "'";
				ResultSet rs = stmt.executeQuery(sql);

				System.out.print("번호\t나이\t이름\t학번\n");
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
		} else if (select == 2) { // 교수찾기
			try {
				Statement stmt = conn.createStatement();
				String sql = "SELECT no, age, name, subject FROM professor WHERE name = '" + findName + "'";
				ResultSet rs = stmt.executeQuery(sql);

				System.out.print("번호\t나이\t이름\t과목\n");
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
		} else if (select == 3) { // 관리자찾기
			try {
				Statement stmt = conn.createStatement();
				String sql = "SELECT no, age, name, part FROM manager WHERE name = '" + findName + "'";
				ResultSet rs = stmt.executeQuery(sql);

				System.out.print("번호\t나이\t이름\t부서\n");
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
		System.out.println("1.학생삭제 2.교수삭제 3.관리자삭제");
		int select = input.nextInt();
		System.out.print("삭제할 이름 입력 --> ");
		String deleteName = input.next();

		if (select == 1) { // 학생삭제
			try {
				Statement stmt = conn.createStatement();
				String sql = "DELETE FROM student WHERE student.name = '" + deleteName + "'";
				int cnt = stmt.executeUpdate(sql);
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
				Statement stmt = conn.createStatement();
				String sql = "DELETE FROM professor WHERE professor.name = '" + deleteName + "'";
				int cnt = stmt.executeUpdate(sql);
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
				Statement stmt = conn.createStatement();
				String sql = "DELETE FROM manager WHERE manager.name = '" + deleteName + "'";
				int cnt = stmt.executeUpdate(sql);
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

	public void list(Scanner input, Connection conn) {
		System.out.println("전체출력");
		System.out.println("1.학생전체출력 2.교수전체출력 3.관리자전체출력");
		System.out.print("메뉴 선택--> ");
		int select = input.nextInt();
		if (select == 1) { // 학생전체출력
			try {
				System.out.print("번호\t나이\t이름\t학번\n");
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
		} else if (select == 2) { // 교수전체출력
			try {
				System.out.print("번호\t나이\t이름\t과목\n");
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
		} else if (select == 3) { // 관리자전체출력
			try {
				System.out.print("번호\t나이\t이름\t부서\n");
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
