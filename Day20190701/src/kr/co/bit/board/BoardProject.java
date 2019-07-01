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
			System.out.println("====게시판 작성====");
			try {
				System.out.println("R: 등록  S: 검색  D: 삭제  U: 수정  L: 목록");
				String protocol = br.readLine();
				if (protocol.equals("R") || protocol.equals("r")) { // 등록
					HashMap<String, String> boardHash = new HashMap<String, String>();

					System.out.print("제목|내용입력: ");
					String titleContent = br.readLine();
					int indexI = titleContent.indexOf("|");
					String title = titleContent.substring(0, indexI);
					String content = titleContent.substring(indexI + 1);

					if (title == null || title == "") {
						System.out.println("공백이나 널일때");
					}
					if (content == null || content == "") {
						System.out.println("공백이나 널일때");
					}

					boardHash.put("title", title);
					boardHash.put("content", content);
					boardHash.put("author", "신용제");
					boardHash.put("day", "20190701");
					boardHash.put("readcount", "0");

					boardList.add(boardHash);

					System.out.println("게시글이 작성 되었습니다.");
				} else if (protocol.equals("S") || protocol.equals("s")) { // 검색
					HashMap<String, String> boardHash = new HashMap<String, String>();
					System.out.print("찾는 게시글 제목입력: ");
					String titleSearch = br.readLine();

					System.out.print("제목\t내용\t작성자\t날짜\t조회수\n");
					for (int i = 0; i < boardList.size(); i++) {
						boardHash = boardList.get(i);
						if (boardHash.get("title").equals(titleSearch)) {
							System.out.print(boardHash.get("title") + "\t");
							System.out.print(boardHash.get("content") + "\t");
							System.out.print(boardHash.get("author") + "\t");
							System.out.print(boardHash.get("day") + "\t");
							System.out.print(boardHash.get("readcount") + "\n");
							System.out.println("해당 게시글이 검색 되었습니다.");
						}
					}
				} else if (protocol.equals("D") || protocol.equals("d")) { // 삭제
					HashMap<String, String> boardHash = new HashMap<String, String>();
					System.out.print("삭제할 게시글 제목 입력: ");
					String titleDelete = br.readLine();
					for (int i = 0; i < boardList.size(); i++) {
						boardHash = boardList.get(i);
						if (boardHash.get("title").equals(titleDelete)) {
							boardList.remove(i);
							System.out.println("해당 게시글은 삭제 되었습니다.");
						}
					}
				} else if (protocol.equals("U") || protocol.equals("u")) { // 수정
					HashMap<String, String> boardHash = new HashMap<String, String>();
					System.out.print("수정할 게시글 제목 입력: ");
					String titleUpdate = br.readLine();

					System.out.println("수정 전 내용입니다.");

					System.out.print("제목\t내용\t작성자\t날짜\t조회수\n");
					for (int i = 0; i < boardList.size(); i++) {
						boardHash = boardList.get(i);
						if (boardHash.get("title").equals(titleUpdate)) {
							System.out.print(boardHash.get("title") + "\t");
							System.out.print(boardHash.get("content") + "\t");
							System.out.print(boardHash.get("author") + "\t");
							System.out.print(boardHash.get("day") + "\t");
							System.out.print(boardHash.get("readcount") + "\n");
							System.out.println("해당 게시글이 검색 되었습니다.");
						
							System.out.print("수정할 제목|내용 입력: ");
							String titleContent = br.readLine();
							int indexI = titleContent.indexOf("|");
							String title = titleContent.substring(0, indexI);
							String content = titleContent.substring(indexI + 1);

							boardHash.put("title", title);
							boardHash.put("content", content);

							boardList.set(i, boardHash);

							System.out.println("게시글이 수정 되었습니다.");
						}
					}
				} else if (protocol.equals("L") || protocol.equals("l")) { // 전체출력, 목록
					HashMap<String, String> boardHash = new HashMap<String, String>();
					System.out.println("====전체출력====");
					System.out.print("제목\t내용\t작성자\t날짜\t조회수\n");
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
