package kr.co.bit;

import java.util.Scanner;

public class Scanner_Test {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("���ڸ� �Է�:");
		int number1 = input.nextInt();
		System.out.println(number1);
		
		System.out.print("���ڸ� �Է�:");
		String str = input.next();
		System.out.println(str);
		
		System.out.print("�Ǽ� �Է�:");
		double sil = input.nextDouble();
		System.out.println(sil);
	}
	
}
