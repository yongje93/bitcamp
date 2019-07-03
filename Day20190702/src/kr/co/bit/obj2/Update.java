package kr.co.bit.obj2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Update {
	private static BufferedReader br;
	private static Connection conn;
	private String titleUpdate;
	private PreparedStatement pstmt;
	private String sql;
	private ResultSet rs;
	private int cnt;
	private int no; // ��ȣ
	private String title; // ����
	private String content; // ����
	private String author; // �ۼ���
	private String day; // ��¥
	private int readcount; // ��ȸ��
	private String titleContent; // ����|����
	private int indexI; // "|" ������ ��ġ�� ��ȯ
	private String titleNew; // ���ο� ����
	private String contentNew; // ���ο� ����

	static {
		br = new BufferedReader(new InputStreamReader(System.in));
		conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Update() {
		titleUpdate = null;	pstmt = null; sql = null;
		rs = null; cnt = 0; no = 0; title = null;
		content = null; author = null; day = null;
		readcount = 0; titleContent = null;
		indexI = 0;	titleNew = null; contentNew = null;
	}

	public void updateTitle() throws IOException {
		System.out.print("������ �Խñ� ���� �Է�: ");
		titleUpdate = br.readLine();	
	}
	
	public void oldBoardSqlSearch() {
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD WHERE TITLE = ?";
	}
	
	public void oldBoardSqlExecute() throws SQLException {
		System.out.println("���� �� �����Դϴ�.");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, titleUpdate);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			no = rs.getInt("no");
			title = rs.getString("title");
			content = rs.getString("content");
			author = rs.getString("author");
			day = rs.getString("day");
			readcount = rs.getInt("readcount");
			System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��\n");
			System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" + day + "\t" + readcount + "\n");
		}
		System.out.println("�ش� �Խñ��� �˻� �Ǿ����ϴ�.");	
	}
	
	public void updateTitleContent() throws IOException {
		System.out.print("������ ����|���� �Է�: ");
		titleContent = br.readLine();
	}
	
	public void titleContentPorcess() {
		indexI = titleContent.indexOf("|");
		titleNew = titleContent.substring(0, indexI);
		contentNew = titleContent.substring(indexI + 1);
	}
	
	public void boardSqlUpdate() {
		sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE TITLE = ?";		
	}
	
	public void boardSqlExecute() throws SQLException {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, titleNew);
		pstmt.setString(2, contentNew);
		pstmt.setString(3, titleUpdate);
		cnt = pstmt.executeUpdate();
	}
	public void updatePorcess() throws IOException, SQLException {
		conn = Register.getConnection();
		updateTitle();
		oldBoardSqlSearch();
		oldBoardSqlExecute();
		updateTitleContent();
		titleContentPorcess();
		boardSqlUpdate();
		boardSqlExecute();
		
		if (cnt == 0) {
			System.out.println("���� ����");
		} else {
			System.out.println(cnt + "���� �Խñ��� �����Ǿ����ϴ�.");
		}
		rs.close();
		pstmt.close();
		conn.close();

	}
}
