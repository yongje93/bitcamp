package kr.co.bit.obj3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardProject {

	public static void main(String[] args) {
		// 1.�ε� Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2.���� Connection conn = DriverManager.getConnection(url, id, pw);
		// 3.�غ�
		// 4.���� executeQuery(�˻�,��ü���) executeUpdate(���, ����, ����)
		// 5.����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Ű���� �Է� (Scanner ��ſ� ��)

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			while (true) {
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin",
						"dkdlxl");
				if (conn == null) {
					System.out.println("����Ŭ ���� ����");
				} else {
					System.out.println("����Ŭ ���� ����");

					System.out.println("====�Խ��� �ۼ�====");

					System.out.println("R: ���  S: �˻�  D: ����  U: ����  L: ���");
					String protocol = br.readLine();
					if (protocol.equals("R") || protocol.equals("r")) { // ���
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
					} else if (protocol.equals("S") || protocol.equals("s")) { // �˻�
						System.out.print("ã�� �Խñ� �����Է�: ");
						String titleSearch = br.readLine();

						System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��\n");
						String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD WHERE TITLE = ?";
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, titleSearch);
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.print(rs.getInt(1) + "\t");
							System.out.print(rs.getString(2) + "\t");
							System.out.print(rs.getString(3) + "\t");
							System.out.print(rs.getString(4) + "\t");
							System.out.print(rs.getString(5) + "\t");
							System.out.print(rs.getInt(6) + "\n");
						}
						rs.close();
						pstmt.close();
						conn.close();
					} else if (protocol.equals("D") || protocol.equals("d")) { // ����
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
					} else if (protocol.equals("U") || protocol.equals("u")) { // ����
						System.out.print("������ �Խñ� ���� �Է�: ");
						String titleUpdate = br.readLine();
						System.out.println("���� �� �����Դϴ�.");
						System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��\n");
						String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD WHERE TITLE = ?";
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, titleUpdate);
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.print(rs.getInt(1) + "\t");
							System.out.print(rs.getString(2) + "\t");
							System.out.print(rs.getString(3) + "\t");
							System.out.print(rs.getString(4) + "\t");
							System.out.print(rs.getString(5) + "\t");
							System.out.print(rs.getInt(6) + "\n");

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
						}
						rs.close();
						pstmt.close();
						conn.close();

					} else if (protocol.equals("L") || protocol.equals("l")) { // ��ü���, ���
						System.out.println("====��ü���====");
						System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��\n");
						String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT FROM BOARD ORDER BY NO ASC";
						PreparedStatement pstmt = conn.prepareStatement(sql);
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.print(rs.getInt(1) + "\t");
							System.out.print(rs.getString(2) + "\t");
							System.out.print(rs.getString(3) + "\t");
							System.out.print(rs.getString(4) + "\t");
							System.out.print(rs.getString(5) + "\t");
							System.out.print(rs.getInt(6) + "\n");
						}
						rs.close();
						pstmt.close();
						conn.close();
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
