package problem;

import java.util.Scanner;

public class Number_10871 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int limit = scan.nextInt();
		int max = scan.nextInt();
		int[] x = new int[limit];
		
		for(int i = 0; i < limit; i++) {
			x[i] = scan.nextInt();
			if(x[i] < max) {
				System.out.print(x[i] + " ");
			}
		}
	}
}
