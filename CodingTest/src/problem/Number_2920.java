package problem;

import java.util.Scanner;

public class Number_2920 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String result = "";
		int[] arr = new int[8];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i] == (arr[i+1] - 1)) {
				result = "ascending";
			} else if (arr[i] == (arr[i+1] +1)) {
				result = "descending";
			} else {
				result = "mixed";
				break;
			}
		}
		System.out.println(result);
	}
}
