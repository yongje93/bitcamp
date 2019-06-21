package kr.co.bit.obj1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HaksaProject {

	public static void main(String[] args) {
		ArrayList<HashMap<String,String>> haksaList = new ArrayList<HashMap<String,String>>(); // arraylist 1차원 배열 hashmap 2차원배열 
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
					HashMap<String,String> haksaHash = new HashMap<String,String>();
					
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
					haksaList.add(haksaHash);
					
					System.out.println("학생이 등록 되었습니다.");
					
				} else if (protocol == 2) {
					HashMap<String,String> haksaHash = new HashMap<String,String>();
					
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
					haksaList.add(haksaHash);
					
					System.out.println("교수 등록 되었습니다.");
					
				} else if (protocol == 3) {
					HashMap<String,String> haksaHash = new HashMap<String,String>();
					
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
					haksaList.add(haksaHash);
					
					System.out.println("관리자 등록 되었습니다.");
					
				} else {
					System.out.println("이전메뉴");
					continue;
				}
			} else if (protocol == 2) {
				System.out.println("찾기");
				System.out.println("찾을 이름을 입력해 주세요.");
				System.out.println("이름:");
				String name = input.next();				
				
				
			} else if (protocol == 3) {
				System.out.println("삭제");
			} else if (protocol == 4) {
				System.out.println("전체출력");
				System.out.println("나이\t이름\t학번\t과목\t부서\n");
				for(int i=0; i<haksaList.size(); i++) {
					HashMap<String, String> haksaHash = haksaList.get(i);
					System.out.print(haksaHash.get("age")+"\t");
					System.out.print(haksaHash.get("name")+"\t");
					System.out.print(haksaHash.get("hakbun")+"\t");
					System.out.print(haksaHash.get("subject")+"\t");
					System.out.print(haksaHash.get("part")+"\n");
					
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
