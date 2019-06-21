package kr.co.bit.haksa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HaksaProject {

	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> haksaList = new ArrayList<HashMap<String, String>>(); // arraylist 1차원 배열
																									// hashmap 2차원배열
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("========메뉴 선택========");
			System.out.println("1.등록 ");
			System.out.println("2.찾기 ");
			System.out.println("3.삭제 ");
			System.out.println("4.전체출력 ");
			System.out.println("----------------");
			System.out.println("0.종료");
			System.out.println("----------------");
			System.out.print("번호를 선택 해주세요.. ");
			int protocol = input.nextInt();

			if (protocol == 1) {
				System.out.println("등록");
				System.out.println("========메뉴 선택========");
				System.out.println("1.학생");
				System.out.println("2.교수");
				System.out.println("3.관리자");
				System.out.println("4.이전메뉴");
				System.out.print("번호를 선택 해주세요.. ");
				protocol = input.nextInt();
				if (protocol == 1) {
					HashMap<String, String> haksaHash = new HashMap<String, String>();

					System.out.println("학생등록");
					System.out.println("나이: ");
					String age = input.next();
					System.out.println("이름: ");
					String name = input.next();
					System.out.println("학번: ");
					String hakbun = input.next();

					haksaHash.put("age", age);
					haksaHash.put("name", name);
					haksaHash.put("hakbun", hakbun);
					haksaHash.put("gubun", "1"); // 1번 학생, 2번 교수, 3번 관리자 구분하기 위한 키.
					haksaList.add(haksaHash);

					System.out.println("학생이 등록 되었습니다.");

				} else if (protocol == 2) {
					HashMap<String, String> haksaHash = new HashMap<String, String>();

					System.out.println("교수등록");
					System.out.println("나이: ");
					String age = input.next();
					System.out.println("이름: ");
					String name = input.next();
					System.out.println("과목: ");
					String subject = input.next();

					haksaHash.put("age", age);
					haksaHash.put("name", name);
					haksaHash.put("subject", subject);
					haksaHash.put("gubun", "2");
					haksaList.add(haksaHash);

					System.out.println("교수 등록 되었습니다.");

				} else if (protocol == 3) {
					HashMap<String, String> haksaHash = new HashMap<String, String>();

					System.out.println("관리자등록");
					System.out.println("나이: ");
					String age = input.next();
					System.out.println("이름: ");
					String name = input.next();
					System.out.println("부서: ");
					String part = input.next();

					haksaHash.put("age", age);
					haksaHash.put("name", name);
					haksaHash.put("part", part);
					haksaHash.put("gubun", "3");
					haksaList.add(haksaHash);

					System.out.println("관리자 등록 되었습니다.");

				} if (protocol == 4) {
					System.out.println("이전메뉴");
					continue;
				}
			} else if (protocol == 2) {
				System.out.println("찾기");
				System.out.println("이름을 입력하세요..");
				String inputName = input.next();

				for (int i = 0; i < haksaList.size(); i++) {
					HashMap<String, String> haksaHash = haksaList.get(i);
					if (inputName.equals(haksaHash.get("name"))) {
						if (haksaHash.get("gubun").equals("1")) {
							System.out.println("나이\t이름\t학번");
							System.out.print(haksaHash.get("age") + "\t");
							System.out.print(haksaHash.get("name") + "\t");
							System.out.print(haksaHash.get("hakbun") + "\n");
						}
						else if (haksaHash.get("gubun").equals("2")) {
							System.out.println("나이\t이름\t과목");
							System.out.print(haksaHash.get("age") + "\t");
							System.out.print(haksaHash.get("name") + "\t");
							System.out.print(haksaHash.get("subject") + "\n");
						}
						else if (haksaHash.get("gubun").equals("3")) {
							System.out.println("나이\t이름\t부서");
							System.out.print(haksaHash.get("age") + "\t");
							System.out.print(haksaHash.get("name") + "\t");
							System.out.print(haksaHash.get("part") + "\n");
						}
					}
				}

			} else if (protocol == 3) {
				System.out.println("삭제");
				System.out.println("삭제할 이름 입력..");
				String nameDelete = input.next();
				for (int i = 0; i < haksaList.size(); i++) {
					HashMap<String, String> haksaHash = haksaList.get(i);
					if (nameDelete.equals(haksaHash.get("name"))) {
						if (haksaHash.get("gubun").equals("1")) { // 학생삭제
							haksaList.remove(i);
							System.out.println("학생"+nameDelete + "님이 삭제되었습니다.");
						} else if (haksaHash.get("gubun").equals("2")) { // 교수삭제
							haksaList.remove(i);
							System.out.println("교수"+nameDelete + "님이 삭제되었습니다.");
						} else if (haksaHash.get("gubun").equals("3")) { // 관리자삭제
							haksaList.remove(i);
							System.out.println("관리자"+nameDelete + "님이 삭제되었습니다.");
						}
					}
				}

			} else if (protocol == 4) {
				System.out.println("전체출력");
				System.out.println("나이\t이름\t학번\t과목\t부서");
				for (int i = 0; i < haksaList.size(); i++) {
					HashMap<String, String> haksaHash = haksaList.get(i);

					if (haksaHash.get("gubun").equals("1")) { // 학생출력
						System.out.print(haksaHash.get("age") + "\t");
						System.out.print(haksaHash.get("name") + "\t");
						System.out.print(haksaHash.get("hakbun") + "\n");

					} else if (haksaHash.get("gubun").equals("2")) { // 교수출력
						System.out.print(haksaHash.get("age") + "\t");
						System.out.print(haksaHash.get("name") + "\t\t");
						System.out.print(haksaHash.get("subject") + "\n");

					} else if (haksaHash.get("gubun").equals("3")) { // 관리자출력
						System.out.print(haksaHash.get("age") + "\t");
						System.out.print(haksaHash.get("name") + "\t\t\t");
						System.out.print(haksaHash.get("part") + "\n");
					}
				}
			} else if (protocol == 0) {
				System.out.println("종료합니다.");
				System.exit(0); // 프로그램 종료
			} else {
				System.out.println("메뉴를 다시 선택해주세요.");
			}
		}

	}

}
