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
			System.out.println("�α������Դϴ�.");
			return;
		}
		
		System.out.print("���̵� �Է�: ");
		id = br.readLine();
		System.out.print("�н����� �Է�: ");
		passwd = br.readLine();

		sql = "select id, passwd from member where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			if (rs.getString("id").equals(id) && rs.getString("passwd").equals(passwd)) {
				System.out.println("ȯ���մϴ�. �α��� �Ǿ����ϴ�.");
				MemberShipMain.session = id;
			} else if (!rs.getString("id").equals(id) && rs.getString("passwd").equals(passwd)) {
				System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
				return;
			} else if (rs.getString("id").equals(id) && !rs.getString("passwd").equals(passwd)) {
				System.out.println("�н����尡 Ʋ�Ƚ��ϴ�.");
				return;
			} else if (!rs.getString("id").equals(id) && !rs.getString("passwd").equals(passwd)) {
				System.out.println("���̵�,�н����� �� �� Ʋ�Ƚ��ϴ�.");
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
