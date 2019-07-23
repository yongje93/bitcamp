package problem;

import java.util.Scanner;

public class Number_2577 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int[] arr = new int[10];

		int result = a * b * c;
		String[] str = String.valueOf(result).split("");
		
		while(result>0) {
			int chk = result % 10;
			result = result / 10;
			arr[chk] += 1;
		}
/*
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals("0")) {
				arr[0]++;
			} else if (str[i].equals("1")) {
				arr[1]++;
			} else if (str[i].equals("2")) {
				arr[2]++;
			} else if (str[i].equals("3")) {
				arr[3]++;
			} else if (str[i].equals("4")) {
				arr[4]++;
			} else if (str[i].equals("5")) {
				arr[5]++;
			} else if (str[i].equals("6")) {
				arr[6]++;
			} else if (str[i].equals("7")) {
				arr[7]++;
			} else if (str[i].equals("8")) {
				arr[8]++;
			} else if (str[i].equals("9")) {
				arr[9]++;
			}
		}
*/
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}
