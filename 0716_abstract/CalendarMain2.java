/*
�⵵ �Է� : 2015
�� �Է� : 7

��  ��  ȭ  ��  ��  ��  ��
           1  2  3  4
5   6  7   8
...
				31
������ - �⵵, �� �Է�
calc() - ���
display() - ���
�ʵ� �����
*/

import java.util.Calendar;
import java.util.Scanner;

public class CalendarMain2 {
	private int year;
	private int month;
	private int startDay;
	private int lastDay;

	public CalendarMain2() {
		Scanner scan = new Scanner(System.in);
		System.out.print("�⵵ �Է� : ");
		year = scan.nextInt();
		System.out.print("�� �Է� : ");
		month = scan.nextInt();
	}

	public void calc() {
		Calendar cal = Calendar.getInstance(); // ���� �ð�
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);

		startDay = cal.get(Calendar.DAY_OF_WEEK);
		lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		System.out.println("���ۿ���" + startDay + " ��¥��" + lastDay);
	}

	public void display() {
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		calc();

		for (int i = 0; i < startDay - 1; i++) {	// ù��° �ٿ� start������ ���� ���
			System.out.print("\t");
		}

		for (int i = 1; i <= lastDay; i++) {
			if (startDay % 7 != 0) {			// 123456 �Ͽ�ȭ�����
				System.out.print(i + "\t");
			} else if (startDay % 7 == 0) {		// 7�̸� �����.
				System.out.println(i);
			}
			startDay++;
		}
		
		if(startDay % 7 != 1) {
			System.out.println();
		}
	}
	public static void main(String[] args) {
		CalendarMain2 cal = new CalendarMain2();
		cal.display();
	}
}