/*
년도 입력 : 2015
월 입력 : 7

일  월  화  수  목  금  토
           1  2  3  4
5   6  7   8
...
				31
생성자 - 년도, 월 입력
calc() - 계산
display() - 출력
필드 맘대루
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
		System.out.print("년도 입력 : ");
		year = scan.nextInt();
		System.out.print("월 입력 : ");
		month = scan.nextInt();
	}

	public void calc() {
		Calendar cal = Calendar.getInstance(); // 현재 시간
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);

		startDay = cal.get(Calendar.DAY_OF_WEEK);
		lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		System.out.println("시작요일" + startDay + " 날짜수" + lastDay);
	}

	public void display() {
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		calc();

		for (int i = 0; i < startDay - 1; i++) {	// 첫번째 줄에 start전까지 공백 출력
			System.out.print("\t");
		}

		for (int i = 1; i <= lastDay; i++) {
			if (startDay % 7 != 0) {			// 123456 일월화수목금
				System.out.print(i + "\t");
			} else if (startDay % 7 == 0) {		// 7이면 토요일.
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