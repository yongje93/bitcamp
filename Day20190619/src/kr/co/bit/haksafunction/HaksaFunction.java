package kr.co.bit.haksafunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HaksaFunction {
	public static int register(Scanner input, ArrayList<HashMap<String, String>> haksaList, int protocol) { // 등록
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

		}
		return protocol;
	}

	public static void search(Scanner input, ArrayList<HashMap<String, String>> haksaList) {
		System.out.println("찾기");
		System.out.println("이름을 입력하세요..");
		String inputName = input.next();

		for (int i = 0; i < haksaList.size(); i++) {
			HashMap<String, String> haksaHash = haksaList.get(i);
			if (haksaHash.get("gubun").equals("1")) {
				if (inputName.equals(haksaHash.get("name"))) {
					System.out.println("나이\t이름\t학번");
					System.out.print(haksaHash.get("age") + "\t");
					System.out.print(haksaHash.get("name") + "\t");
					System.out.print(haksaHash.get("hakbun") + "\n");
				}
			} else if (haksaHash.get("gubun").equals("2")) {
				if (inputName.equals(haksaHash.get("name"))) {
					System.out.println("나이\t이름\t과목");
					System.out.print(haksaHash.get("age") + "\t");
					System.out.print(haksaHash.get("name") + "\t");
					System.out.print(haksaHash.get("subject") + "\n");
				}
			} else if (haksaHash.get("gubun").equals("3")) {
				if (inputName.equals(haksaHash.get("name"))) {
					System.out.println("나이\t이름\t부서");
					System.out.print(haksaHash.get("age") + "\t");
					System.out.print(haksaHash.get("name") + "\t");
					System.out.print(haksaHash.get("part") + "\n");
				}
			}

//			if (inputName.equals(haksaHash.get("name"))) {
//				if (haksaHash.get("gubun").equals("1")) {
//					System.out.println("나이\t이름\t학번");
//					System.out.print(haksaHash.get("age") + "\t");
//					System.out.print(haksaHash.get("name") + "\t");
//					System.out.print(haksaHash.get("hakbun") + "\n");
//				} else if (haksaHash.get("gubun").equals("2")) {
//					System.out.println("나이\t이름\t과목");
//					System.out.print(haksaHash.get("age") + "\t");
//					System.out.print(haksaHash.get("name") + "\t");
//					System.out.print(haksaHash.get("subject") + "\n");
//				} else if (haksaHash.get("gubun").equals("3")) {
//					System.out.println("나이\t이름\t부서");
//					System.out.print(haksaHash.get("age") + "\t");
//					System.out.print(haksaHash.get("name") + "\t");
//					System.out.print(haksaHash.get("part") + "\n");
//				}
			
		}
	}

	public static void delete(Scanner input, ArrayList<HashMap<String, String>> haksaList) {
		System.out.println("삭제");
		System.out.println("삭제할 이름 입력..");
		String nameDelete = input.next();
		for (int i = 0; i < haksaList.size(); i++) {
			HashMap<String, String> haksaHash = haksaList.get(i);
			
			if (haksaHash.get("gubun").equals("1")) {
				if (nameDelete.equals(haksaHash.get("name"))) {
					haksaList.remove(i);
					System.out.println("학생 " + nameDelete + " 님이 삭제되었습니다.");
				}
			} else if (haksaHash.get("gubun").equals("2")) {
				if (nameDelete.equals(haksaHash.get("name"))) {
					haksaList.remove(i);
					System.out.println("교수 " + nameDelete + " 님이 삭제되었습니다.");
				}
			} else if (haksaHash.get("gubun").equals("3")) {
				if (nameDelete.equals(haksaHash.get("name"))) {
					haksaList.remove(i);
					System.out.println("관리자 " + nameDelete + " 님이 삭제되었습니다.");
				}
			}
			
//			if (nameDelete.equals(haksaHash.get("name"))) {
//				if (haksaHash.get("gubun").equals("1")) { // 학생삭제
//					haksaList.remove(i);
//					System.out.println("학생 " + nameDelete + " 님이 삭제되었습니다.");
//				} else if (haksaHash.get("gubun").equals("2")) { // 교수삭제
//					haksaList.remove(i);
//					System.out.println("교수 " + nameDelete + " 님이 삭제되었습니다.");
//				} else if (haksaHash.get("gubun").equals("3")) { // 관리자삭제
//					haksaList.remove(i);
//					System.out.println("관리자 " + nameDelete + " 님이 삭제되었습니다.");
//				}
//			}
		}
	}

	public static void list(Scanner input, ArrayList<HashMap<String, String>> haksaList) {
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
	}

}
