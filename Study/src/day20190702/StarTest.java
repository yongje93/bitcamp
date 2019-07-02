package day20190702;

import java.util.Scanner;

public class StarTest {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("입력받은 개수만큼 츨력: ");
		int num = input.nextInt();

		for (int i = 0; i < num; i++) {
			// 왼쪽 상단에 빈 공간을 출력하기 위한 반복문
			for (int j = i; j < num; j++) {
				System.out.print(" ");
			}
			// 정삼각형의 왼쪽 부분을 담당하는 반복문
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			// 정삼각형의 오른쪽 부분을 담당하는 반복문
			for (int j = 0; j < i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		// 하단 역삼각형을 출력하는 반복문
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = i; j < num; j++) {
				System.out.print("*");
			}
			for (int j = i + 1; j < num; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
