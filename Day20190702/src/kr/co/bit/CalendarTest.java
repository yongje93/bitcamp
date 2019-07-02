package kr.co.bit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar myCalendar = Calendar.getInstance();
		
		myCalendar.set(Calendar.YEAR, 2019);
		myCalendar.set(Calendar.MONTH, 7);
		myCalendar.set(Calendar.DAY_OF_MONTH, 2);
		myCalendar.set(Calendar.HOUR_OF_DAY, 12);
		myCalendar.set(Calendar.MINUTE, 15);
		myCalendar.set(Calendar.SECOND, 33);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
		DateFormat df = DateFormat.getDateTimeInstance();
		Date date = myCalendar.getTime();
		
		System.out.println(sdf.format(date));
		System.out.println(df.format(date));
	}

}
