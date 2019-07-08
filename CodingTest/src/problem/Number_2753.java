package problem;

import java.util.Scanner;

public class Number_2753 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int year = 0;
		year = input.nextInt();
		if (year % 4 == 0 && year % 100 != 0) {
			System.out.println("1");
		} else if (year % 400 == 0) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}

	}

}
