package kr.co.bit.obj2;

import java.util.Scanner;

public class Ju {
	static Scanner input;
	static String ju;
	static int select;
	static int menu;
	static String gob;
	static int tang;
	
	public static String juSelect() {
		System.out.println("�ֹ��ϼ���yes/no");
		ju = input.next();
		return ju;
	}

	public static void juDisp() {
		if (select == 1) {
			System.out.println("�ֹ�����");
		} else {
			System.out.println("�ֹ����");
		}
	}
	public static int menuSelect() {
		System.out.println("�޴�1.�����2.«��3.������");
		menu = input.nextInt();
		return menu;
	}

	public static void menuDisp() {
		if (select == 1) {
			System.out.println("����鼱��");
		} else if (select == 2) {
			System.out.println("«�ͼ���");
		} else if (select == 3) {
			System.out.println("����������");
		}
	}

	public static String gobSelect() {
		System.out.println("����⼱��yes/no");
		gob = input.next();
		return gob;
	}

	public static void gobDisp() {
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

	public static int tangSelect() {
		System.out.println("�޴�1.��2.��3.��");
		tang = input.nextInt();
		return tang;
	}

	public static void tangDisp() {
		if (select == 1) {
			System.out.println("����������");
		} else if (select == 2) {
			System.out.println("����������");
		} else if (select == 3) {
			System.out.println("����������");
		}
	}
	
}
