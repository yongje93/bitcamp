package kr.co.bit;

public class For_Test1 {

	public static void main(String[] args) {
		int number1 = 0;
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			number1++; // number1 = number1 + 1;
			sum += number1; // sum = sum + number1;
		}
		System.out.println("증가=" + number1 + " 합계=" + sum);
	}

}
