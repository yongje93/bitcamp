package kr.co.bit;

public class While_Test7 {
	public static void main(String[] args) {
		int number = 0;
		char c = 'A';
		aaa: while (true) { // aaa는 라벨 이름을 붙여준다.
			while (true) {
				System.out.print(c++ + "");
				number++;
				if (number % 5 == 0) {
					break;
				}
				if (number == 26) {
					break aaa;
				}
			}
			System.out.println();
		}
	}
}
