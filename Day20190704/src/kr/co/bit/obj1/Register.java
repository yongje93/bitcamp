package kr.co.bit.obj1;

import java.io.IOException;
import java.sql.SQLException;

public class Register extends Board {

	public Register() {
		super();
	}

	public void setNo() throws IOException {
		System.out.print("�Խñ۹�ȣ�Է�: ");
		no = Integer.parseInt(br.readLine());
	}

	public void setTitleContent() throws IOException {
		System.out.print("����|�����Է�: ");
		titleContent = br.readLine();
	}

	public void boardSQL() {
		sql = "INSERT INTO BOARD(NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT) VALUES(?,?,?,?,?,?)";
	}

	public void boardSqlExecute() throws SQLException{
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.setString(2, title);
		pstmt.setString(3, content);
		pstmt.setString(4, "�ſ���");
		pstmt.setString(5, "20190703");
		pstmt.setInt(6, 0);
		cnt = pstmt.executeUpdate();
		if (cnt == 0) {
			System.out.println("��� ����");
		} else {
			System.out.println(cnt + "���� �Խñ��� ��ϵǾ����ϴ�.");
		}
	}
	
	@Override
	public void boardClose() {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void boardProcess() throws IOException, SQLException {
		setNo();
		setTitleContent();
		titleContentPorcess();
		boardSQL();
		boardSqlExecute();
		//closeAll();
		//boardClose();
	}

}
