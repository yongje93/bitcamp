package kr.co.bit;

import java.util.Scanner;

public class Test1 {
	public static int display() {
		Scanner input = new Scanner(System.in);
		System.out.println("1.��� 2.���� 3.���� 4.����");
		int number = input.nextInt();

		return number;
	}

	public static void inputRecord() {
		System.out.println("���");
	}

	public static void deleteRecord() {
		System.out.println("����");
	}

	public static void sortRecord() {
		System.out.println("����");
	}

	public static void exitRecord() {
		System.out.println("����");
		System.exit(0);
	}

	public static void main(String[] args) {
		while (true) {
			switch (display()) {
			case 1:	//���
				inputRecord();
				break;
			case 2:	//����
				deleteRecord();
				break;
			case 3:	//����
				sortRecord();
				break;
			case 4:	//����
				exitRecord();
				break;
			}
		}
	}
}
