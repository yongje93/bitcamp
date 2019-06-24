package kr.co.bit;

import java.util.Scanner;

public class SchoolMain {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ManSchool manSchool = new ManSchool(90, 80, 70, 60);
		WomanSchool womanSchool = new WomanSchool(100, 90, 80, 70);
		ManGongupSchool manGongup = new ManGongupSchool(97, 85, 75, 65, 50);
		WomanSangupSchool womanSang = new WomanSangupSchool(88, 99, 77, 66, 100);

		while (true) {
			System.out.println("1.�������б� 2.�������б� 3.���ڰ�������б� 4.���ڻ������б�");
			int protocol = input.nextInt();

			if (protocol == 1) {
				System.out.println("�������б�");
				System.out.print("���� = " + manSchool.getKor() + " ���� = " + manSchool.getEng() + " ���� = "
						+ manSchool.getMat() + " ��� = " + manSchool.getGisul() + " ���� = " + manSchool.total() 
						+ " ��� = " 	+ manSchool.average() + "\n");
				// System.out.println(manSchool.toString());
			} else if (protocol == 2) {
				System.out.println("�������б�");
				System.out.print("���� = " + womanSchool.getKor() + " ���� = " + womanSchool.getEng() + " ���� = "
						+ womanSchool.getMat() + " ���� = " + womanSchool.getGajung() + " ���� = " + womanSchool.total()
						+ " ��� = " + womanSchool.average() + "\n");
				// System.out.println(womanSchool.toString());
			} else if (protocol == 3) {
				System.out.println("���ڰ�������б�");
				System.out.print("���� = " + manGongup.getKor() + " ���� = " + manGongup.getEng() + " ���� = "
						+ manGongup.getMat() + " ��� = " + manGongup.getGisul() + "" + " ���� = " + manGongup.getGongup()
						+ " ���� = " + manGongup.total() + " ��� = " + manGongup.average() + "\n");
				// System.out.println(manGongup.toString());
			} else if (protocol == 4) {
				System.out.println("���ڻ������б�");
				System.out.print("���� = " + womanSang.getKor() + " ���� = " + womanSang.getEng() + " ���� = "
						+ womanSang.getMat() + " ���� = " + womanSang.getGajung() + "" + " ��� = " + womanSang.getSangup()
						+ " ���� = " + womanSang.total() + " ��� = " + womanSang.average() + "\n");
				// System.out.println(womanSang.toString());
			}
			System.out.println();
		}

	}
}
