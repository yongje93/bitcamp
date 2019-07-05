package kr.co.bit.obj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class MemberShipMain_error {
	private static String session;

	static {
		session = null;
	}

	public static void main(String[] args) throws SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		String id = null;
		String passwd = null;
		String address = null;
		String tel = null;

		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			while (true) {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");

				if (conn == null) {
					System.out.println("데이터베이스 연결 실패");
				} else {
					System.out.println("데이터베이스 연결 성공");
				}

				System.out.println("R: 회원가입  L: 회원목록  S: ID찾기  D: 회원탈퇴  E: 회원수정  I: 로그인  O: 로그아웃");
				String protocol = br.readLine();
				if (protocol.equals("R") | protocol.equals("r")) { // 회원가입
					if (session != null) {
						System.out.println("로그인중입니다.");
						continue;
					}
					System.out.print("아이디 입력: ");
					id = br.readLine();
					System.out.print("패스워드 입력: ");
					passwd = br.readLine();
					System.out.print("주소 입력: ");
					address = br.readLine();
					System.out.print("전화번호 입력: ");
					tel = br.readLine();

					sql = "INSERT INTO MEMBER (ID, PASSWD, ADDRESS, TEL) VALUES (?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, passwd);
					pstmt.setString(3, address);
					pstmt.setString(4, tel);
					int cnt = pstmt.executeUpdate();
					if (cnt == 0) {
						System.out.println("회원등록 실패");
					} else {
						System.out.println(cnt + "명의 회원이 등록되었습니다.");
					}
					pstmt.close();
					conn.close();

				} else if (protocol.equals("L") | protocol.equals("l")) { // 회원목록
					System.out.println("전체출력");
					System.out.print("회원아이디\t회원패스워드\t회원주소\t회원전화번호\n");

					sql = "SELECT ID, PASSWD, ADDRESS, TEL FROM MEMBER ORDER BY ID ASC";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						id = rs.getString("id");
						passwd = rs.getString("passwd");
						address = rs.getString("address");
						tel = rs.getString("tel");
						System.out.print(id + "\t" + passwd + "\t\t" + address + "\t" + tel + "\n");
					}
					rs.close();
					pstmt.close();
					conn.close();
					
				} else if (protocol.equals("S") | protocol.equals("s")) { // 회원찾기
					System.out.print("찾는 아이디 입력: ");
					id = br.readLine();

					sql = "SELECT id, passwd, address, tel FROM MEMBER WHERE ID = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();

					System.out.print("회원아이디\t회원패스워드\t회원주소\t회원전화번호\n");
					while (rs.next()) {
						id = rs.getString("id");
						passwd = rs.getString("passwd");
						address = rs.getString("address");
						tel = rs.getString("tel");
						System.out.print(id + "\t" + passwd + "\t\t" + address + "\t" + tel + "\n");
					}
					rs.close();
					pstmt.close();
					conn.close();
					
				} else if (protocol.equals("D") | protocol.equals("d")) { // 회원탈퇴
					if (session == null) {
						System.out.println("로그인하세요.");
						continue;
					}

					sql = "DELETE FROM MEMBER WHERE ID = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, session);
					int cnt = pstmt.executeUpdate();
					if (cnt == 0) {
						System.out.println("회원탈퇴 실패");
					} else {
						System.out.println(cnt + "명의 회원이 탈퇴되었습니다.");
					}
					session = null;

					pstmt.close();
					conn.close();

				} else if (protocol.equals("E") | protocol.equals("e")) { // 회원수정
					if (session == null) {
						System.out.println("로그인하세요.");
						continue;
					}
					sql = "SELECT id, passwd, address, tel FROM MEMBER WHERE ID = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, session);
					rs = pstmt.executeQuery();

					while (rs.next()) {
						id = rs.getString("id");
						passwd = rs.getString("passwd");
						address = rs.getString("address");
						tel = rs.getString("tel");
						System.out.print(id + "\t" + passwd + "\t\t" + address + "\t" + tel + "\n");
					}

					System.out.print("아이디 입력: ");
					id = br.readLine();
					System.out.print("패스워드 입력: ");
					passwd = br.readLine();
					System.out.print("주소 입력: ");
					address = br.readLine();
					System.out.print("전화번호 입력: ");
					tel = br.readLine();

					sql = "UPDATE MEMBER SET ID = ?, PASSWD = ?, ADDRESS = ?, TEL = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, passwd);
					pstmt.setString(3, address);
					pstmt.setString(4, tel);
					int cnt = pstmt.executeUpdate();
					if (cnt == 0) {
						System.out.println("회원수정 실패");
					} else {
						System.out.println(cnt + "명의 회원이 수정되었습니다.");
					}
					pstmt.close();
					conn.close();
					
				} else if (protocol.equals("I") | protocol.equals("i")) { // 로그인
					System.out.print("아이디 입력: ");
					id = br.readLine();
					System.out.print("패스워드 입력: ");
					passwd = br.readLine();

					sql = "select id, passwd from member where id = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						if (rs.getString("id").equals(id) && rs.getString("passwd").equals(passwd)) {
							System.out.println("환영합니다. 로그인 되었습니다.");
							session = id;
						} else if (!rs.getString("id").equals(id) && rs.getString("passwd").equals(passwd)) {
							System.out.println("아이디가 틀렸습니다.");
							return;
						} else if (rs.getString("id").equals(id) && !rs.getString("passwd").equals(passwd)) {
							System.out.println("패스워드가 틀렸습니다.");
							return;
						} else if (!rs.getString("id").equals(id) && !rs.getString("passwd").equals(passwd)) {
							System.out.println("아이디,패스워드 둘 다 틀렸습니다.");
							return;
						}
					}
					rs.close();
					pstmt.close();
					conn.close();
					
				} else if (protocol.equals("O") | protocol.equals("o")) { // 로그아웃
					if (session == null) {
						System.out.println("로그인하세요.");
						continue;
					}
					System.out.println("로그아웃 되었습니다.");
					session = null;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
