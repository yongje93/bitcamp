package kr.co.bit.obj2;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardFunction {
	public static void register(BufferedReader br, Connection conn) throws NumberFormatException, IOException, SQLException {
		System.out.print("�Խñ۹�ȣ�Է�: ");
		int no = Integer.parseInt(br.readLine());
		System.out.print("����|�����Է�: ");
		String titleContent = br.readLine();
		int indexI = titleContent.indexOf("|");
		String title = titleContent.substring(0, indexI);
		String content = titleContent.substring(indexI + 1);

		String sql = "INSERT INTO BOARD(NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT) VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.setString(2, title);
		pstmt.setString(3, content);
		pstmt.setString(4, "�ſ���");
		pstmt.setString(5, "20190701");
		pstmt.setInt(6, 0);

		int cnt = pstmt.executeUpdate();

		if (cnt == 0) {
			System.out.println("��� ����");
		} else {
			System.out.println(cnt + "���� �Խñ��� ��ϵǾ����ϴ�.");
		}
		pstmt.close();
		conn.close();

	}

	public static void search(BufferedReader br, Connection conn) throws NumberFormatException, IOException, SQLException {
		System.out.print("ã�� �Խñ� �����Է�: ");
		String titleSearch = br.readLine();

		System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��\n");
		String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD WHERE TITLE = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, titleSearch);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String day = rs.getString("day");
			int readcount = rs.getInt("readcount");
			System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" + day + "\t" + readcount + "\n");
		}
		rs.close();
		pstmt.close();
		conn.close();
	}

	public static void delete(BufferedReader br, Connection conn) throws NumberFormatException, IOException, SQLException {
		System.out.print("������ �Խñ� ���� �Է�: ");
		String titleDelete = br.readLine();

		String sql = "DELETE FROM BOARD WHERE TITLE = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, titleDelete);
		int cnt = pstmt.executeUpdate();
		if (cnt == 0) {
			System.out.println("���� ����");
		} else {
			System.out.println(cnt + "���� �Խñ��� �����Ǿ����ϴ�.");
		}
		pstmt.close();
		conn.close();
	}

	public static void update(BufferedReader br, Connection conn) throws NumberFormatException, IOException, SQLException {
		System.out.print("������ �Խñ� ���� �Է�: ");
		String titleUpdate = br.readLine();
		System.out.println("���� �� �����Դϴ�.");
		System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��\n");
		String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD WHERE TITLE = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, titleUpdate);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String day = rs.getString("day");
			int readcount = rs.getInt("readcount");
			System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" + day + "\t"	+ readcount + "\n");
		}
		System.out.println("�ش� �Խñ��� �˻� �Ǿ����ϴ�.");
		System.out.print("������ ����|���� �Է�: ");
		String titleContent = br.readLine();
		int indexI = titleContent.indexOf("|");
		String title = titleContent.substring(0, indexI);
		String content = titleContent.substring(indexI + 1);

		sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE TITLE = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, titleUpdate);

		int cnt = pstmt.executeUpdate();
		if (cnt == 0) {
			System.out.println("���� ����");
		} else {
			System.out.println(cnt + "���� �Խñ��� �����Ǿ����ϴ�.");
		}
		rs.close();
		pstmt.close();
		conn.close();

	}

	public static void list(Connection conn) throws SQLException {
		System.out.println("====��ü���====");
		System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��\n");
		String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD ORDER BY NO ASC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String day = rs.getString("day");
			int readcount = rs.getInt("readcount");
			System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" + day + "\t"	+ readcount + "\n");
		}
		rs.close();
		pstmt.close();
		conn.close();
	}

}