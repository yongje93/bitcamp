package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.SQLException;

public class Edit extends MemberShip {

	public Edit() {
		super();
	}
	
	public void editProcess() throws SQLException, IOException {
		conn = getConnection();

		if (MemberShipMain.session == null) {
			System.out.println("로그인하세요.");
			return;
		}
		sql = "SELECT id, passwd, address, tel FROM MEMBER WHERE ID = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, MemberShipMain.session);
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
