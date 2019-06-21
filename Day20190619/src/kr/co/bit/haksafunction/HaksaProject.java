package kr.co.bit.haksafunction;

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

				HaksaFunction.register(input, haksaList, protocol);

				if (protocol == 4) {
					System.out.println("이전메뉴");
					continue;
				}

			} else if (protocol == 2) {
				HaksaFunction.search(input, haksaList);
			} else if (protocol == 3) {
				HaksaFunction.delete(input, haksaList);
			} else if (protocol == 4) {
				HaksaFunction.list(input, haksaList);
			} else if (protocol == 0) {
				System.out.println("종료합니다.");
				System.exit(0); // 프로그램 종료
			} else {
				System.out.println("메뉴를 다시 선택해주세요.");
			}
		}

	}

}
