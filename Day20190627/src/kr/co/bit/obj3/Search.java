package kr.co.bit.obj3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Search {
	private int select; // 학생, 교수, 관리자 선책
	private Scanner input;
	private String findName; // 찾고자 하는 이름.
	private Connection conn;
	private Statement stmt;
	private ResultSet rs; // 테이블의 첫번째 행을 가리킴. 초기화는 null로 해줌.

	private int no; // 번호
	private String age; // 나이
	private String name; // 이름
	private String hakbun; // 학번
	private String subject; // 과목
	private String part; // 부서

	private String sql; // 쿼리문

	public Search() {
		select = 0;
		findName = null;
		input = new Scanner(System.in);
		stmt = null;
		no = 0;
		age = null;
		name = null;
		hakbun = null;

		sql = null;
		rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 로드
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl"); // 연결
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void searchProcess() {
		System.out.println("1.학생찾기 2.교수찾기 3.관리자찾기");
		select = input.nextInt();
		System.out.print("찾을 이름 입력 --> ");
		findName = input.next();

		if (select == 1) { // 학생찾기
			try {
				stmt = conn.createStatement();
				sql = "SELECT no, age, name, hakbun FROM student WHERE name = '" + findName + "'";
				rs = stmt.executeQuery(sql);

				System.out.print("번호\t나이\t이름\t학번\n");
				while (rs.next()) {
					no = rs.getInt("no");
					age = rs.getString("age");
					name = rs.getString("name");
					hakbun = rs.getString("hakbun");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + hakbun + "\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 2) { // 교수찾기
			try {
				stmt = conn.createStatement();
				sql = "SELECT no, age, name, subject FROM professor WHERE name = '" + findName + "'";
				rs = stmt.executeQuery(sql);

				System.out.print("번호\t나이\t이름\t과목\n");
				while (rs.next()) {
					no = rs.getInt("no");
					age = rs.getString("age");
					name = rs.getString("name");
					subject = rs.getString("subject");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + subject + "\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 3) { // 관리자찾기
			try {
				stmt = conn.createStatement();
				sql = "SELECT no, age, name, part FROM manager WHERE name = '" + findName + "'";
				rs = stmt.executeQuery(sql);

				System.out.print("번호\t나이\t이름\t부서\n");
				while (rs.next()) {
					no = rs.getInt("no");
					age = rs.getString("age");
					name = rs.getString("name");
					part = rs.getString("part");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + part + "\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
