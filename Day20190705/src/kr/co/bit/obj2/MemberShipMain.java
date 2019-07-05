package kr.co.bit.obj2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class MemberShipMain {
	public static String session;

	static {
		session = null;
	}

	public static void main(String[] args) throws SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Connection conn = null;
		Register register = new Register();
		List list = new List();
		Search search = new Search();
		Delete delete = new Delete();
		Edit edit = new Edit();
		Login login = new Login();
		Logout logout = new Logout();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			while (true) {
				conn = MemberShip.getConnection();
				if (conn == null) {
					System.out.println("데이터베이스 연결 실패");
				} else {
					System.out.println("데이터베이스 연결 성공");
				}
				System.out.println("R: 회원가입  L: 회원목록  S: ID찾기  D: 회원탈퇴  E: 회원수정  I: 로그인  O: 로그아웃");
				String protocol = br.readLine();
				if (protocol.equals("R") | protocol.equals("r")) { // 회원가입
					register.registerProcess();
				} else if (protocol.equals("L") | protocol.equals("l")) { // 회원목록
					list.listProcess();
				} else if (protocol.equals("S") | protocol.equals("s")) { // 회원찾기
					search.searchProcess();
				} else if (protocol.equals("D") | protocol.equals("d")) { // 회원탈퇴
					delete.deleteProcess();
				} else if (protocol.equals("E") | protocol.equals("e")) { // 회원수정
					edit.editProcess();
				} else if (protocol.equals("I") | protocol.equals("i")) { // 로그인
					login.loginProcess();
				} else if (protocol.equals("O") | protocol.equals("o")) { // 로그아웃
					logout.logoutProcess();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
