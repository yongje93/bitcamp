package kr.co.bit;

import java.util.Scanner;

public class DoWhile_Test5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int randomNumber = (int) (Math.random() * 100) + 1;
		int inputNumber = 0;
		do {
			System.out.println("���ڸ� �Է��ϼ���.");
			inputNumber = input.nextInt();
			if (inputNumber == randomNumber) {
				System.out.println("�������ϴ�.");
				break;
			} else if (inputNumber < randomNumber) {
				System.out.println("���ڰ� �۽��ϴ�.");
			} else {
				System.out.println("���ڰ� Ů�ϴ�.");
			}
		} while (true);
	}
}
