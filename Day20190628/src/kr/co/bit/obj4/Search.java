package kr.co.bit.obj4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Search {
	private int select; // 학생, 교수, 관리자 선책
	private String findName; // 찾고자 하는 이름.
	private PreparedStatement pstmt;
	private ResultSet rs; // 테이블의 첫번째 행을 가리킴. 초기화는 null로 해줌.

	private int no; // 번호
	private String age; // 나이
	private String name; // 이름
	private String hakbun; // 학번
	private String subject; // 과목
	private String part; // 부서

	private Scanner input;
	private String sql; // 쿼리문

	public Search() {
		select = 0;
		findName = null;
		pstmt = null;
		no = 0;
		age = null;
		name = null;
		hakbun = null;
		input = new Scanner(System.in);
		
		sql = null;
		rs = null;
	}

	public void searchProcess(Connection conn) {
		System.out.println("1.학생찾기 2.교수찾기 3.관리자찾기");
		select = input.nextInt();
		System.out.print("찾을 이름 입력 --> ");
		findName = input.next();

		if (select == 1) { // 학생찾기
			try {
				pstmt = conn.prepareStatement(sql);
				sql = "SELECT no, age, name, hakbun FROM student WHERE name = ?";
				pstmt.setString(1, findName);
				rs = pstmt.executeQuery();

				System.out.print("번호\t나이\t이름\t학번\n");
				while (rs.next()) {
					no = rs.getInt("no");
					age = rs.getString("age");
					name = rs.getString("name");
					hakbun = rs.getString("hakbun");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + hakbun + "\n");
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 2) { // 교수찾기
			try {
				pstmt = conn.prepareStatement(sql);
				sql = "SELECT no, age, name, subject FROM professor WHERE name = ?";
				pstmt.setString(1, findName);
				rs = pstmt.executeQuery();

				System.out.print("번호\t나이\t이름\t과목\n");
				while (rs.next()) {
					no = rs.getInt("no");
					age = rs.getString("age");
					name = rs.getString("name");
					subject = rs.getString("subject");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + subject + "\n");
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 3) { // 관리자찾기
			try {
				pstmt = conn.prepareStatement(sql);
				sql = "SELECT no, age, name, part FROM manager WHERE name = ?";
				pstmt.setString(1, findName);
				rs = pstmt.executeQuery();

				System.out.print("번호\t나이\t이름\t부서\n");
				while (rs.next()) {
					no = rs.getInt("no");
					age = rs.getString("age");
					name = rs.getString("name");
					part = rs.getString("part");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + part + "\n");
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
