package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.SQLException;

public class Login extends MemberShip {

	public Login() {
		super();
	}
	
	public void loginProcess() throws IOException, SQLException {
		conn = getConnection();

		if (MemberShipMain.session != null) {
			System.out.println("로그인중입니다.");
			return;
		}
		
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
				MemberShipMain.session = id;
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
		closeAll();
	}

	@Override
	public void closeAll() {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
