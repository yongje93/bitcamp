package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.SQLException;

public class Search extends MemberShip {

	public Search() {
		super();
	}
	
	public void searchProcess() throws IOException, SQLException {
		conn = getConnection();

		System.out.print("찾는 아이디 입력: ");
		id = br.readLine();

		sql = "SELECT id, passwd, address, tel FROM MEMBER WHERE ID = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();

		if (rs.next()) {
			id = rs.getString("id");
			passwd = rs.getString("passwd");
			address = rs.getString("address");
			tel = rs.getString("tel");
			System.out.print("회원아이디\t회원패스워드\t회원주소\t회원전화번호\n");
			System.out.print(id + "\t" + passwd + "\t\t" + address + "\t" + tel + "\n");
		} else {
			System.out.println("찾는 아이디가 없습니다.");
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
