package problem;

import java.util.Scanner;

public class Number_10951 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt()) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			System.out.println(x + y);
		}
	}
}
