package kr.co.bit.obj1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Update {
	private Connection conn;
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

	public Update() {
		titleUpdate = null;
		pstmt = null;
		sql = null;
		rs = null;
		cnt = 0;
		no = 0;
		title = null;
		content = null;
		author = null;
		day = null;
		readcount = 0;
		titleContent = null;
		indexI = 0;
		conn = null;
	}

	public void updateTitle() throws IOException {
		System.out.print("������ �Խñ� ���� �Է�: ");
		titleUpdate = Register.br.readLine();
	}

	public void oldBoardSqlSearch() {
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD WHERE TITLE = ?";
	}

	public void updateConfirm() throws SQLException {
		System.out.println("���� �� �����Դϴ�.");
		System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��\n");
	}

	public void updateTitleContent() throws IOException {
		System.out.print("������ ����|���� �Է�: ");
		titleContent = Register.br.readLine();
	}

	public void titleContentPorcess() {
		indexI = titleContent.indexOf("|");
		title = titleContent.substring(0, indexI);
		content = titleContent.substring(indexI + 1);
	}

	public void boardSqlUpdate() {
		sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE TITLE = ?";
	}

	public void boardSqlExecute() throws SQLException {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, titleUpdate);
		cnt = pstmt.executeUpdate();
		if (cnt == 0) {
			System.out.println("���� ����");
		} else {
			System.out.println(cnt + "���� �Խñ��� �����Ǿ����ϴ�.");
		}
	}

	public void updatePorcess() throws IOException, SQLException {
		conn = Register.getConnection();
		updateTitle();
		oldBoardSqlSearch();
		updateConfirm();
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
			System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" + day + "\t" + readcount + "\n");
			System.out.println("�ش� �Խñ��� �˻� �Ǿ����ϴ�.");
		}
		updateTitleContent();
		titleContentPorcess();
		boardSqlUpdate();
		boardSqlExecute();
		rs.close();
		pstmt.close();
		conn.close();

	}
}
