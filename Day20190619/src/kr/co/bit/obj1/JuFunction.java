package kr.co.bit.obj1;

import java.util.Scanner;

public class JuFunction {
	public static String juSelect(Scanner input) {
		System.out.println("�ֹ��ϼ���yes/no");
		String ju = input.next();
		return ju;
	}

	public static void juDisp(int select) {
		if (select == 1) {
			System.out.println("�ֹ�����");
		} else {
			System.out.println("�ֹ����");
		}
	}

	public static int menuSelect(Scanner input) {
		System.out.println("�޴�1.�����2.«��3.������");
		int menu = input.nextInt();
		return menu;
	}

	public static void menuDisp(int select) {
		if (select == 1) {
			System.out.println("����鼱��");
		} else if (select == 2) {
			System.out.println("«�ͼ���");
		} else if (select == 3) {
			System.out.println("����������");
		}
	}

	public static String gobSelect(Scanner input) {
		System.out.println("����⼱��yes/no");
		String gob = input.next();
		return gob;
	}

	public static void gobDisp(int select) {
		if (select == 1) {
			System.out.println("��������⼱��");
		} else if (select == 2) {
			System.out.println("����麸�뼱��");
		} else if (select == 3) {
			System.out.println("«�Ͱ���⼱��");
		} else if (select == 4) {
			System.out.println("«�ͺ��뼱��");
		}
	}

	public static int tangSelect(Scanner input) {
		System.out.println("�޴�1.��2.��3.��");
		int tang = input.nextInt();
		return tang;
	}

	public static void tangDisp(int select) {
		if (select == 1) {
			System.out.println("����������");
		} else if (select == 2) {
			System.out.println("����������");
		} else if (select == 3) {
			System.out.println("����������");
		}
	}
}