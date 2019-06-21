package kr.co.bit;

public class For_Test6 {

	public static void main(String[] args) {
		int num = 0;
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(++num + "\t");
			}
			System.out.println();
		}
		num = 0;
		for (int x = 1; x <= 5; x++) {
			for (int y = 1; y <= (6 - x); y++) {
				System.out.print(++num+"\t");
			}
			System.out.println();
		}
	}

}
