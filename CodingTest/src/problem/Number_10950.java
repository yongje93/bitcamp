package problem;

import java.util.Scanner;

public class Number_10950 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		for(int i = 0; i < count; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			System.out.println(x+y);
		}

	}
}
