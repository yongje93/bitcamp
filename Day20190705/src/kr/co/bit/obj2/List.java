package kr.co.bit.obj2;

import java.sql.SQLException;

public class List extends MemberShip {

	public List() {
		super();
	} 
	
	public void listProcess() throws SQLException {
		conn = getConnection();
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
