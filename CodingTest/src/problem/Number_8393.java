package problem;

import java.util.Scanner;

public class Number_8393 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int total = 0;
		for (int i = 0; i <= n; i++) {
			total+=i;
		}
		System.out.println(total);
	}
}
