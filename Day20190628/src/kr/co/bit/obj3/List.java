package kr.co.bit.obj3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class List {
	private int select; // 학생, 교수, 관리자 선책
	private Statement stmt;
	private ResultSet rs; // 테이블의 첫번째 행을 가리킴. 초기화는 null로 해줌.

	private int no; // 번호
	private String age; // 나이
	private String name; // 이름
	private String hakbun; // 학번
	private String subject; // 과목
	private String part; // 부서

	private String p_age; // 전체출력 교수나이
	private String p_name; // 전체출력 교수이름
	private String m_age; // 전체출력 관리자나이
	private String m_name; // 전체출력 관리자이름

	private Scanner input;
	private String sql; // 쿼리문

	public List() {
		select = 0;
		stmt = null;
		no = 0;
		age = null;
		name = null;
		hakbun = null;
		p_age = null;
		p_name = null;
		m_age = null;
		m_name = null;

		input = new Scanner(System.in);
		sql = null;
		rs = null;
	}

	public void listProcess(Connection conn) {
		System.out.println("전체출력");
		System.out.println("1.학생전체출력 2.교수전체출력 3.관리자전체출력 4.학사전체출력");
		System.out.print("메뉴 선택--> ");
		select = input.nextInt();
		if (select == 1) { // 학생전체출력
			try {
				System.out.print("번호\t나이\t이름\t학번\n");
				stmt = conn.createStatement();
				sql = "SELECT no, age, name, hakbun FROM student ORDER BY no ASC";
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					no = rs.getInt("no");
					age = rs.getString("age");
					name = rs.getString("name");
					hakbun = rs.getString("hakbun");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + hakbun + "\n");
				}
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 2) { // 교수전체출력
			try {
				System.out.print("번호\t나이\t이름\t과목\n");
				stmt = conn.createStatement();
				sql = "SELECT no, age, name, subject FROM professor ORDER BY no ASC";
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					no = rs.getInt("no");
					age = rs.getString("age");
					name = rs.getString("name");
					subject = rs.getString("subject");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + subject + "\n");
				}
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 3) { // 관리자전체출력
			try {
				System.out.print("번호\t나이\t이름\t부서\n");
				stmt = conn.createStatement();
				sql = "SELECT no, age, name, part FROM manager ORDER BY no ASC";
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					no = rs.getInt("no");
					age = rs.getString("age");
					name = rs.getString("name");
					part = rs.getString("part");
					System.out.print(no + "\t" + age + "\t" + name + "\t" + part + "\n");
				}
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (select == 4) { // 학사 전체출력
			try {
				System.out.print("번호\t나이\t이름\t학번\t교수나이\t교수이름\t과목\t교수나이\t교수이름\t부서\n");
				stmt = conn.createStatement();
				sql = "SELECT s.no as 번호, s.age as 나이, s.name as 이름, s.hakbun as 학번, p.age as 교수나이 , p.name as 교수이름, p.subject as 과목, m.age as 관리자나이, m.name as 관리자이름, m.part as 부서 FROM (student s left join professor p on s.no = p. no) left join manager m on s.no = m.no ORDER BY 번호 ASC";
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					no = rs.getInt("번호");
					age = rs.getString("나이");
					name = rs.getString("이름");
					hakbun = rs.getString("학번");
					p_age = rs.getString("교수나이");
					p_name = rs.getString("교수이름");
					subject = rs.getString("과목");
					m_age = rs.getString("관리자나이");
					m_name = rs.getString("관리자이름");
					part = rs.getString("부서");

					System.out.print(no + "\t" + age + "\t" + name + "\t" + hakbun + "\t" + p_age + "\t" + p_name + "\t"
							+ subject + "\t" + m_age + "\t" + m_name + "\t" + part + "\n");
				}
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
