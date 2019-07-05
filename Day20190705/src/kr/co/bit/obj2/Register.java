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
			System.out.println("�α������Դϴ�.");
			return;
		}
		
		System.out.print("���̵� �Է�: ");
		id = br.readLine();
		System.out.print("�н����� �Է�: ");
		passwd = br.readLine();
		System.out.print("�ּ� �Է�: ");
		address = br.readLine();
		System.out.print("��ȭ��ȣ �Է�: ");
		tel = br.readLine();

		sql = "INSERT INTO MEMBER (ID, PASSWD, ADDRESS, TEL) VALUES (?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, passwd);
		pstmt.setString(3, address);
		pstmt.setString(4, tel);
		int cnt = pstmt.executeUpdate();
		if (cnt == 0) {
			System.out.println("ȸ����� ����");
		} else {
			System.out.println(cnt + "���� ȸ���� ��ϵǾ����ϴ�.");
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
