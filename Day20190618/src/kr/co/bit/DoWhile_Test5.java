package kr.co.bit;

import java.util.Scanner;

public class DoWhile_Test5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int randomNumber = (int) (Math.random() * 100) + 1;
		int inputNumber = 0;
		do {
			System.out.println("숫자를 입력하세요.");
			inputNumber = input.nextInt();
			if (inputNumber == randomNumber) {
				System.out.println("맞혔습니다.");
				break;
			} else if (inputNumber < randomNumber) {
				System.out.println("숫자가 작습니다.");
			} else {
				System.out.println("숫자가 큽니다.");
			}
		} while (true);
	}
}
