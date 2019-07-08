package problem;

import java.util.Scanner;

public class Number_1546 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int x = scan.nextInt();
		double max = 0.0;
		double total = 0.0;
		double[] arr1 = new double[x];
		
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = scan.nextInt();
		}
		
		for (double j : arr1) {
			if(j > max) {
				max = j;
			}
		}
		
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = arr1[i]/max*100;	
		}
		
		for (int i = 0; i < arr1.length; i++) {
			total += arr1[i];
		}
		
		double avg = total/(double)x;
		
		System.out.println(avg);
		
	}

}
