package problem;

import java.util.Scanner;

public class Number_2562 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[9];
		int max = arr[0];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
			if (max < arr[i]) {
				max = arr[i];
				index = i;
			}
		}
		System.out.println(max);
		System.out.println((index+1));		
	}

}
