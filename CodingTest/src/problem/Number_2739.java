package problem;

import java.util.Scanner;

public class Number_2739 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = 0;
		n = input.nextInt();
		for (int i = 1; i < 10; i++) {
			System.out.println(n + " * " + i + " = " + i * n);
		}

	}
}
