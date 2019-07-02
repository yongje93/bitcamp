package kr.co.bit;

import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date date1 = new Date();
		System.out.println("year:" + date1.getYear());
		System.out.println("month:" + date1.getMonth());
		System.out.println("date:" + date1.getDate());
		System.out.println(date1);
	}
}
