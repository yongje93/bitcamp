package kr.co.bit.obj2;

public class Array_Test2 {

	public static void main(String[] args) {
		int arrayNumber[];
		String names[];

		arrayNumber = new int[3];
		names = new String[3];

		arrayNumber[0] = 1;
		arrayNumber[1] = 2;
		arrayNumber[2] = 3;
		
		names[0] = "홍길동";
		names[1] = "전우치";
		names[2] = "신용제";

		for (int i = 0; i < 3; i++) {
			System.out.println("arrayNumber [ " + i + " ] = " + arrayNumber[i]);
			System.out.println("names [ " + i + " ] = " + names[i]);
		}
	}

}
