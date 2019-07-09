package problem;

import java.util.Arrays;
import java.util.Scanner;

public class Number_10817 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = new int[3];
		String[] str = scan.nextLine().split(" ");
		for (int i = 0; i < str.length; i++) {
			array[i]= Integer.parseInt(str[i]);
		}
		Arrays.sort(array);
		System.out.println(array[1]);
	}

}
