package kr.co.bit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBTest {

	public static void main(String[] args) {
		// 1. 로드(적재) - 자바에게 오라클 사용한다고 알려주기.
		// 2. 연결(Connection) (url(경로),아이디,패스워드)
		// 3. 준비(Statement) 3-1 공간준비
		// 					 3-2 문장준비
		// 4. 실행(execute) 1) executeUpdate(); - 등록, 삭제, 수정
		// 				   2) executeQuery(); - 검색, 목록
		// 5. 종료(conn.close, stmt.close)
		Scanner input = new Scanner(System.in);

		try {
			while (true) {
				Class.forName("oracle.jdbc.dirver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
				System.out.println("1.등록 2.삭제 3.전체출력 4.검색");
				int protocol = input.nextInt();

				if (conn == null) {
					System.out.println("데이터베이스 연결 실패");
				} else if (protocol == 1) {	//등록
					System.out.println("데이터베이스 연결 성공");
					System.out.println("학생등록");

					System.out.print("번호입력: ");
					int no = input.nextInt();
					System.out.print("나이 : ");
					String age = input.next();
					System.out.print("이름: ");
					String name = input.next();
					System.out.print("학번: ");
					String hakbun = input.next();

					Statement stmt = conn.createStatement(); // 공간준비
					String sql = "insert into student(no, age, name, hakbun) values (" + no + ",'" + age + "','" + name
							+ "','" + hakbun + "')"; // 문장준비
					int cnt = stmt.executeUpdate(sql); // 실행
					if (cnt == 0) {
						System.out.println("등록이 실패 되었습니다.");
					} else {
						System.out.println(cnt + "건 학생이 등록 되었습니다.");
						conn.close();	//종료
						stmt.close();	//종료
					}
				} else if (protocol == 2) {	//삭제
					System.out.println("학생 삭제");
					System.out.print("삭제할 이름 입력: ");
					String deleteName = input.next();

					Statement stmt = conn.createStatement(); // 공간준비
					String sql = "DELETE FROM student WHERE name = '" + deleteName + "'"; // 문장준비
					int cnt = stmt.executeUpdate(sql);	//실행
					if (cnt == 0) {
						System.out.println("학생 삭제 실패");
					} else {
						System.out.println(cnt + "건 학생 삭제 성공");
						conn.close(); 	//종료
						stmt.close(); 	//종료
					}
				} else if (protocol == 3) {	//전체출력
					System.out.println("전체 출력");
					System.out.print("번호\t나이\t이름\t학번\n");
					Statement stmt = conn.createStatement(); // 공간준비
					String sql = "SELECT no, age, name, hakbun FROM student ORDER BY NO ASC";	//문장준비
					ResultSet rs = stmt.executeQuery(sql);	//실행
					
					while (rs.next()) {
						int no = rs.getInt("no");
						String age = rs.getString("age");
						String name = rs.getString("name");
						String hakbun = rs.getString("hakbun");
						System.out.println(no+"\t"+age+"\t"+name+"\t"+hakbun);
					}
					conn.close();	//종료
					stmt.close();	//종료
					
				} else if (protocol == 4) {
					System.out.print("검색할 이름 입력: ");
					String searchName = input.next();
					System.out.print("번호\t나이\t이름\t학번\n");
					Statement stmt = conn.createStatement(); // 공간준비
					String sql = "SELECT no, age, name, hakbun FROM student WHERE name = '" + searchName + "'";	//문장준비
					ResultSet rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						int no = rs.getInt("no");
						String age = rs.getString("age");
						String name = rs.getString("name");
						String hakbun = rs.getString("hakbun");
						System.out.println(no+"\t"+age+"\t"+name+"\t"+hakbun);
					}
					conn.close();	//종료
					stmt.close();	//종료
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
