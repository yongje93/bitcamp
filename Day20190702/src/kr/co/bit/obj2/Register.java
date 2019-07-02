package kr.co.bit.obj2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register {
	public static BufferedReader br;
	private static Connection conn;
	private int no; // ��ȣ
	private String titleContent; // ����|����
	private int indexI; // "|" ������ ��ġ�� ��ȯ
	private String title; // ����
	private String content; // ����
	private String sql; // ������
	private PreparedStatement pstmt;
	private int cnt;

	static {
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Register() {
		conn = null; no = 0; titleContent = null;
		indexI = 0; title = null; content = null;
		sql = null; pstmt = null; cnt = 0;
	}
	
	public static Connection getConnection() throws SQLException {
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
		return conn;
	}

	public void setNo() throws IOException {
		System.out.print("�Խñ۹�ȣ�Է�: ");
		no = Integer.parseInt(br.readLine());
	}

	public void setTitleContent() throws IOException {
		System.out.print("����|�����Է�: ");
		titleContent = br.readLine();
	}

	public void titleContentPorcess() {
		indexI = titleContent.indexOf("|");
		title = titleContent.substring(0, indexI);
		content = titleContent.substring(indexI + 1);
	}
	
	public void boardSqlRegister() {
		sql = "INSERT INTO BOARD(NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT) VALUES(?,?,?,?,?,?)";
	}
	
	public void boardSqlExecute() throws SQLException {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.setString(2, title);
		pstmt.setString(3, content);
		pstmt.setString(4, "�ſ���");
		pstmt.setString(5, "20190701");
		pstmt.setInt(6, 0);
		cnt = pstmt.executeUpdate();
	}
		
	public void registerProcess() throws IOException, SQLException {
		setNo();
		setTitleContent();
		titleContentPorcess();
		boardSqlRegister();
		boardSqlExecute();
		if (cnt == 0) {
			System.out.println("��� ����");
		} else {
			System.out.println(cnt + "���� �Խñ��� ��ϵǾ����ϴ�.");
		}
		pstmt.close();
		conn.close();

	}

}
