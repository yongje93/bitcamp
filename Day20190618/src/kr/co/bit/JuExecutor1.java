package kr.co.bit;

import java.util.Scanner;

public class JuExecutor1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("�ֹ��ϼ��� y/n");
			char ju = input.next().charAt(0);
			if (ju == 'y' || ju == 'Y') {
				System.out.println("�ֹ�����");
				System.out.println("�޴� 1.¥��� 2.«�� 3.������");
				int menu = input.nextInt();
				if (menu == 1) {
					System.out.println("¥��� ����");
					System.out.println("¥��� ����� y/n");
					char gob = input.next().charAt(0);
					if (gob == 'y' || gob == 'Y') {
						System.out.println("¥��� �����");
					} else {
						System.out.println("¥��� ����");
					}
				} else if (menu == 2) {
					System.out.println("«�� ����");
					System.out.println("«�� ����� y/n");
					char gob = input.next().charAt(0);
					if (gob == 'y' || gob == 'Y') {
						System.out.println("«�� �����");
					} else {
						System.out.println("«�� ����");
					}
				} else if (menu == 3) {
					System.out.println("������ ����");
					System.out.println("�޴� 1.�� 2.�� 3.��");
					int tang = input.nextInt();
					if (tang == 1) {
						System.out.println("������ ��");
					} else if (tang == 2) {
						System.out.println("������ ��");
					} else if (tang == 3) {
						System.out.println("������ ��");
					}
				} else {
					System.out.println("1,2,3 �߿� �����ϼ���.");
				}
			} else {
				System.out.println("�ֹ����");
				break;
			}
		}
	}

}
