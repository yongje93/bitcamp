package kr.co.bit.board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class BoardProject {

	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> boardList = new ArrayList<HashMap<String, String>>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("====�Խ��� �ۼ�====");
			try {
				System.out.println("R: ���  S: �˻�  D: ����  U: ����  L: ���");
				String protocol = br.readLine();
				if (protocol.equals("R") || protocol.equals("r")) { // ���
					HashMap<String, String> boardHash = new HashMap<String, String>();

					System.out.print("����|�����Է�: ");
					String titleContent = br.readLine();
					int indexI = titleContent.indexOf("|");
					String title = titleContent.substring(0, indexI);
					String content = titleContent.substring(indexI + 1);

					if (title == null || title == "") {
						System.out.println("�����̳� ���϶�");
					}
					if (content == null || content == "") {
						System.out.println("�����̳� ���϶�");
					}

					boardHash.put("title", title);
					boardHash.put("content", content);
					boardHash.put("author", "�ſ���");
					boardHash.put("day", "20190701");
					boardHash.put("readcount", "0");

					boardList.add(boardHash);

					System.out.println("�Խñ��� �ۼ� �Ǿ����ϴ�.");
				} else if (protocol.equals("S") || protocol.equals("s")) { // �˻�
					HashMap<String, String> boardHash = new HashMap<String, String>();
					System.out.print("ã�� �Խñ� �����Է�: ");
					String titleSearch = br.readLine();

					System.out.print("����\t����\t�ۼ���\t��¥\t��ȸ��\n");
					for (int i = 0; i < boardList.size(); i++) {
						boardHash = boardList.get(i);
						if (boardHash.get("title").equals(titleSearch)) {
							System.out.print(boardHash.get("title") + "\t");
							System.out.print(boardHash.get("content") + "\t");
							System.out.print(boardHash.get("author") + "\t");
							System.out.print(boardHash.get("day") + "\t");
							System.out.print(boardHash.get("readcount") + "\n");
							System.out.println("�ش� �Խñ��� �˻� �Ǿ����ϴ�.");
						}
					}
				} else if (protocol.equals("D") || protocol.equals("d")) { // ����
					HashMap<String, String> boardHash = new HashMap<String, String>();
					System.out.print("������ �Խñ� ���� �Է�: ");
					String titleDelete = br.readLine();
					for (int i = 0; i < boardList.size(); i++) {
						boardHash = boardList.get(i);
						if (boardHash.get("title").equals(titleDelete)) {
							boardList.remove(i);
							System.out.println("�ش� �Խñ��� ���� �Ǿ����ϴ�.");
						}
					}
				} else if (protocol.equals("U") || protocol.equals("u")) { // ����
					HashMap<String, String> boardHash = new HashMap<String, String>();
					System.out.print("������ �Խñ� ���� �Է�: ");
					String titleUpdate = br.readLine();

					System.out.println("���� �� �����Դϴ�.");

					System.out.print("����\t����\t�ۼ���\t��¥\t��ȸ��\n");
					for (int i = 0; i < boardList.size(); i++) {
						boardHash = boardList.get(i);
						if (boardHash.get("title").equals(titleUpdate)) {
							System.out.print(boardHash.get("title") + "\t");
							System.out.print(boardHash.get("content") + "\t");
							System.out.print(boardHash.get("author") + "\t");
							System.out.print(boardHash.get("day") + "\t");
							System.out.print(boardHash.get("readcount") + "\n");
							System.out.println("�ش� �Խñ��� �˻� �Ǿ����ϴ�.");
						
							System.out.print("������ ����|���� �Է�: ");
							String titleContent = br.readLine();
							int indexI = titleContent.indexOf("|");
							String title = titleContent.substring(0, indexI);
							String content = titleContent.substring(indexI + 1);

							boardHash.put("title", title);
							boardHash.put("content", content);

							boardList.set(i, boardHash);

							System.out.println("�Խñ��� ���� �Ǿ����ϴ�.");
						}
					}
				} else if (protocol.equals("L") || protocol.equals("l")) { // ��ü���, ���
					HashMap<String, String> boardHash = new HashMap<String, String>();
					System.out.println("====��ü���====");
					System.out.print("����\t����\t�ۼ���\t��¥\t��ȸ��\n");
					for (int i = 0; i < boardList.size(); i++) {
						boardHash = boardList.get(i);
						System.out.print(boardHash.get("title") + "\t");
						System.out.print(boardHash.get("content") + "\t");
						System.out.print(boardHash.get("author") + "\t");
						System.out.print(boardHash.get("day") + "\t");
						System.out.print(boardHash.get("readcount") + "\n");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
