package kr.co.bit;

import java.util.Scanner;

public class JuExecuter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("�ֹ��ϼ���. yes/no");
			String ju = input.next();
			if (ju.equals("yes") || ju.equals("YES")) {
				System.out.println("�ֹ�����");
				System.out.println("�޴� 1.¥��� 2.«�� 3.������");
				int menu = input.nextInt();
				if (menu == 1) {
					System.out.println("¥��鼱��");
					System.out.println("����� ����. yes/no");
					String gob = input.next();
					if (gob.equals("yes") || gob.equals("YES")) {
						System.out.println("¥��� ����� ����");
					} else {
						System.out.println("¥��� ���� ����");
					}
				} else if (menu == 2) {
					System.out.println("«�ͼ���");
					System.out.println("����� ����. yes/no");
					String gob = input.next();
					if (gob.equals("yes") || gob.equals("YES")) {
						System.out.println("¥��� ����� ����");
					} else {
						System.out.println("¥��� ���� ����");
					}
				} else if (menu == 3) {
					System.out.println("����������");
					System.out.println("�޴� 1.�� 2.�� 3.��");
					int tang = input.nextInt();
					if(tang == 1) { 
						System.out.println("������ ��");
					} else if (tang == 2) {
						System.out.println("������ ��");
					} else if (tang == 3) {
						System.out.println("������ ��");
					}
				}
			} else {
				System.out.println("�ֹ����");
				break;
			}
		}

	}

}
