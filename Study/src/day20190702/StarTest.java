package day20190702;

import java.util.Scanner;

public class StarTest {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("�Է¹��� ������ŭ ����: ");
		int num = input.nextInt();

		for (int i = 0; i < num; i++) {
			// ���� ��ܿ� �� ������ ����ϱ� ���� �ݺ���
			for (int j = i; j < num; j++) {
				System.out.print(" ");
			}
			// ���ﰢ���� ���� �κ��� ����ϴ� �ݺ���
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			// ���ﰢ���� ������ �κ��� ����ϴ� �ݺ���
			for (int j = 0; j < i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		// �ϴ� ���ﰢ���� ����ϴ� �ݺ���
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
