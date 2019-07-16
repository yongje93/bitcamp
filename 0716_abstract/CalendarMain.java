import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class CalendarMain {
	public CalendarMain() {
		Date date = new Date();
		System.out.println("오늘 날짜 = " + date);
	
		SimpleDateFormat sdf = new SimpleDateFormat("y년 MM월 dd일 E요일 H:m:s");
		System.out.println("오늘 날짜 = " + sdf.format(date));
		
		// 시스템에 날짜 얻어온다.
		//Calendar cal = new GregorianCalendar();	// 서브클래스 이용한 생성
		Calendar cal = Calendar.getInstance();		// 메소드를 이용한 생성		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK);	// 일 월 화~
		String weekDay = null;
		switch(week) {
			case 1: weekDay = "일요일"; break;
			case 2: weekDay = "월요일"; break;
			case 3: weekDay = "화요일"; break;
			case 4: weekDay = "수요일"; break;
			case 5: weekDay = "목요일"; break;
			case 6: weekDay = "금요일"; break;
			case 7: weekDay = "토요일"; break;
		}
		System.out.println("오늘 날짜 = " + year + "년 " + month + "월 " + day + "일 " + weekDay);
	}

	public static void main(String[] args) {
		new CalendarMain(); 
	}
}
