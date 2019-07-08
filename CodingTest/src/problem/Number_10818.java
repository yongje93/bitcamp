package problem;

import java.util.Scanner;

public class Number_10818 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int x = scan.nextInt();
		int max = -1000000;
		int min = 1000000;

		int[] arr1 = new int[x];

		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = scan.nextInt();
		}

		for (int j : arr1) {
			if (j > max) {
				max = j;
			}
			if (j < min) {
				min = j;
			}
		}
		System.out.println(min + " " + max);
	}
	
//	Scanner input = new Scanner(System.in);
//	int n = Integer.parseInt(input.nextLine());
//	String[] str = input.nextLine().split(" ");	
//	int[] array = new int[n];
//	for(int i = 0; i<str.length; i++) {
//		array[i] = Integer.parseInt(str[i]);
//	}
//	int max = array[0];
//	int min = array[0];
//	
//	for(int i = 0; i < array.length; i++) {
//		if(max < array[i]) {
//			max = array[i];
//		}
//		if(min > array[i]) {
//			min = array[i];
//		}
//	}
//	System.out.println(min + " "+ max);

}
