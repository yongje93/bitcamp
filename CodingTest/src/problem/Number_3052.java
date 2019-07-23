package problem;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Number_3052 {
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		int[] rem = new int[10];
//		int count = 1;
//		
//		for (int i = 0; i < 10; i++) {
//			int x = scan.nextInt();
//			rem[i] = x % 42;
//		}
//		Arrays.sort(rem);
//		for (int i = 0; i < 9; i++) {
//			if(rem[i]!=rem[i+1]) count++;
//		}
//		
//		System.out.println(count);
		Scanner sc = new Scanner(System.in);
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < 10; i++)
			set.add(sc.nextInt() % 42);
		System.out.println(set.size());
	}
}
