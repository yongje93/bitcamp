package kr.co.bit.obj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class MemberShip {
	protected static BufferedReader br;
	protected static Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	protected String sql;
	protected int cnt;
	
	protected String id;	// ���̵�
	protected String passwd;	// �н�����
	protected String address;	// �ּ�
	protected String tel;	// ��ȭ��ȣ
	
	static {
		br = new BufferedReader(new InputStreamReader(System.in));
		conn = null;
	}
	
	public MemberShip() {
		id = null;
		passwd = null;
		address = null;
		tel = null;
	}
	
	public static Connection getConnection() throws SQLException { // ����.
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
		return conn;
	}

	public abstract void closeAll();
	
}
