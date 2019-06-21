package kr.co.bit.obj2;

import java.util.Scanner;

public class Array_Test5 {

	public static void main(String[] args) {
		String names[] = new String[] { "가가가", "나나나", "다다다", "라라라", "마마마", "바바바" };
		Scanner input = new Scanner(System.in);
		int index = -1;
		do {
			System.out.println("검색할 이름을 입력하세요.");
			System.out.println("이름 :");
			String name = input.next();
			for (int i = 0; i < names.length; i++) {
				if (name.equals(names[i])) {
					index = i;
				}
			}
			if (index != -1) {
				System.out.println(name + "은 배열의" + index + "인덱스에서 찾았습니다.");
				break;
			}
			System.out.println("해당하는 이름 존재하지 않습니다.");
		} while (true);
	}

}
