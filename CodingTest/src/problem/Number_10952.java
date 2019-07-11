package problem;

import java.util.Scanner;

public class Number_10952 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			if(x == 0 && y == 0) break;
			System.out.println(x + y);
		}
	}
}
