package problem;

import java.util.Scanner;

public class Number_1110 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count = 0;
		
		int a = n / 10; // �����ڸ���
		int b = n % 10; // �����ڸ���
		int num = n; // ���� �� ����.
		
		while (true) {
			int tmp = b;
			b = (a+b) % 10;
			a = tmp;
			count++;
			if (num == (a*10+b)) {
				System.out.println(count);
				break;
			} 
		}
	}
}
