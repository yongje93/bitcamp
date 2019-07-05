package kr.co.bit.obj2;

import java.sql.SQLException;

public class Delete extends MemberShip {

	public Delete() {
		super();
	}
	
	public void deleteProcess() throws SQLException {
		conn = getConnection();

		if (MemberShipMain.session == null) {
			System.out.println("로그인하세요.");
			return;
		}

		sql = "DELETE FROM MEMBER WHERE ID = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, MemberShipMain.session);
		int cnt = pstmt.executeUpdate();
		if (cnt == 0) {
			System.out.println("회원탈퇴 실패");
		} else {
			System.out.println(cnt + "명의 회원이 탈퇴되었습니다.");
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
