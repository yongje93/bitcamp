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
		
		names[0] = "ȫ�浿";
		names[1] = "����ġ";
		names[2] = "�ſ���";

		for (int i = 0; i < 3; i++) {
			System.out.println("arrayNumber [ " + i + " ] = " + arrayNumber[i]);
			System.out.println("names [ " + i + " ] = " + names[i]);
		}
	}

}
