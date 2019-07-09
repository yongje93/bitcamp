package problem;

import java.util.Scanner;

public class Number_2588 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		
		int n_100 = b/100;
		int n_10 = (b%100)/10;
		int n_1 = (b%10)/1;
		
		System.out.println(a*n_1);
		System.out.println(a*n_10);
		System.out.println(a*n_100);
		System.out.println(a*b);
	}
}
