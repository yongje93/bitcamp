package kr.co.bit;

import java.util.Scanner;

public class Scanner_Test {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("숫자를 입력:");
		int number1 = input.nextInt();
		System.out.println(number1);
		
		System.out.print("문자를 입력:");
		String str = input.next();
		System.out.println(str);
		
		System.out.print("실수 입력:");
		double sil = input.nextDouble();
		System.out.println(sil);
	}
	
}
