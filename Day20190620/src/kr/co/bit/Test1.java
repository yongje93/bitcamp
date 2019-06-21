package kr.co.bit;

import java.util.Scanner;

public class Test1 {
	public static int display() {
		Scanner input = new Scanner(System.in);
		System.out.println("1.등록 2.삭제 3.정렬 4.종료");
		int number = input.nextInt();

		return number;
	}

	public static void inputRecord() {
		System.out.println("등록");
	}

	public static void deleteRecord() {
		System.out.println("삭제");
	}

	public static void sortRecord() {
		System.out.println("정렬");
	}

	public static void exitRecord() {
		System.out.println("종료");
		System.exit(0);
	}

	public static void main(String[] args) {
		while (true) {
			switch (display()) {
			case 1:	//등록
				inputRecord();
				break;
			case 2:	//삭제
				deleteRecord();
				break;
			case 3:	//정렬
				sortRecord();
				break;
			case 4:	//종료
				exitRecord();
				break;
			}
		}
	}
}
