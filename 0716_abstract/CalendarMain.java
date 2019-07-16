import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class CalendarMain {
	public CalendarMain() {
		Date date = new Date();
		System.out.println("���� ��¥ = " + date);
	
		SimpleDateFormat sdf = new SimpleDateFormat("y�� MM�� dd�� E���� H:m:s");
		System.out.println("���� ��¥ = " + sdf.format(date));
		
		// �ý��ۿ� ��¥ ���´�.
		//Calendar cal = new GregorianCalendar();	// ����Ŭ���� �̿��� ����
		Calendar cal = Calendar.getInstance();		// �޼ҵ带 �̿��� ����		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK);	// �� �� ȭ~
		String weekDay = null;
		switch(week) {
			case 1: weekDay = "�Ͽ���"; break;
			case 2: weekDay = "������"; break;
			case 3: weekDay = "ȭ����"; break;
			case 4: weekDay = "������"; break;
			case 5: weekDay = "�����"; break;
			case 6: weekDay = "�ݿ���"; break;
			case 7: weekDay = "�����"; break;
		}
		System.out.println("���� ��¥ = " + year + "�� " + month + "�� " + day + "�� " + weekDay);
	}

	public static void main(String[] args) {
		new CalendarMain(); 
	}
}
