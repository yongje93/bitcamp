package kr.co.bit.obj2;

import java.sql.SQLException;

public class Delete extends MemberShip {

	public Delete() {
		super();
	}
	
	public void deleteProcess() throws SQLException {
		conn = getConnection();

		if (MemberShipMain.session == null) {
			System.out.println("�α����ϼ���.");
			return;
		}

		sql = "DELETE FROM MEMBER WHERE ID = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, MemberShipMain.session);
		int cnt = pstmt.executeUpdate();
		if (cnt == 0) {
			System.out.println("ȸ��Ż�� ����");
		} else {
			System.out.println(cnt + "���� ȸ���� Ż��Ǿ����ϴ�.");
		}
		MemberShipMain.session = null;
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
