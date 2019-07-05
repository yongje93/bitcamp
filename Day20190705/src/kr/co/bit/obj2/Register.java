package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.SQLException;

public class Register extends MemberShip {
	
	public Register() {
		super();
	}
	
	public void registerProcess() throws IOException, SQLException {
		conn = getConnection();
		if (MemberShipMain.session != null) {
			System.out.println("로그인중입니다.");
			return;
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
		closeAll();
	}

	@Override
	public void closeAll() {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
