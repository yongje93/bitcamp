package kr.co.bit.obj1;

import java.util.Scanner;

public class JuFunction {
	public static String juSelect(Scanner input) {
		System.out.println("주문하세요yes/no");
		String ju = input.next();
		return ju;
	}

	public static void juDisp(int select) {
		if (select == 1) {
			System.out.println("주문선택");
		} else {
			System.out.println("주문취소");
		}
	}

	public static int menuSelect(Scanner input) {
		System.out.println("메뉴1.자장면2.짬뽕3.탕수육");
		int menu = input.nextInt();
		return menu;
	}

	public static void menuDisp(int select) {
		if (select == 1) {
			System.out.println("자장면선택");
		} else if (select == 2) {
			System.out.println("짬뽕선택");
		} else if (select == 3) {
			System.out.println("탕수육선택");
		}
	}

	public static String gobSelect(Scanner input) {
		System.out.println("곱배기선택yes/no");
		String gob = input.next();
		return gob;
	}

	public static void gobDisp(int select) {
		if (select == 1) {
			System.out.println("자장면곱배기선택");
		} else if (select == 2) {
			System.out.println("자장면보통선택");
		} else if (select == 3) {
			System.out.println("짬뽕곱배기선택");
		} else if (select == 4) {
			System.out.println("짬뽕보통선택");
		}
	}

	public static int tangSelect(Scanner input) {
		System.out.println("메뉴1.대2.중3.소");
		int tang = input.nextInt();
		return tang;
	}

	public static void tangDisp(int select) {
		if (select == 1) {
			System.out.println("탕수육대자");
		} else if (select == 2) {
			System.out.println("탕수육중자");
		} else if (select == 3) {
			System.out.println("탕수육소자");
		}
	}
}