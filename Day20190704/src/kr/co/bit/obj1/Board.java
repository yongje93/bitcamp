package kr.co.bit.obj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Board {
	protected static BufferedReader br;
	public static Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	protected String sql; // ������
	protected int no; // ��ȣ
	protected String title; // ����
	protected String content; // ����
	protected String author; // �ۼ���
	protected String day; // �ۼ�����
	protected int readcount; // ��ȸ��
	protected int cnt; // executeUpdate�� ��ȯ��
	protected String titleContent; // ����|����
	protected int indexI; // "|" ������ ��ġ ��ȯ

	static {
		br = new BufferedReader(new InputStreamReader(System.in));
		conn = null;
	}

	public Board() {
		pstmt = null;
		rs = null;
		sql = null;
		no = 0;
		title = null;
		content = null;
		author = null;
		day = null;
		readcount = 0;
		cnt = 0;
		titleContent = null;
		indexI = 0;
	}

	public static Connection getConnection() throws SQLException { // ����.
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
		return conn;
	}
	
	public void boardTitle() {
		System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t\t��ȸ��\n");
	}
	
	public void titleContentPorcess() { // ����|�̸� ���� �Է��ϸ� ������ ����
		indexI = titleContent.indexOf("|");
		title = titleContent.substring(0, indexI);
		content = titleContent.substring(indexI + 1);
	}
	
	public abstract void boardSQL();	
	public abstract void boardClose();
	//public abstract void boardSqlExecute() throws SQLException;
	public abstract void boardProcess() throws IOException, SQLException;
	
	public void closeAll() { // rs, pstmt, conn close���ִ� �Լ�.
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
