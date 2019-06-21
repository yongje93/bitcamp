package kr.co.bit;

public class Time {
	// 인스턴스변수
	int hour;
	int minute;
	int second;

	public void set() {
		int lv = 0;
		System.out.println("출력");
		return; // 함수를 호출한 곳으로 되돌아가라.
	}

	public int add(int x, int y, String opt) {
		int result = 0;
		if (opt.equals("+")) {
			result = x + y;
		}
		return result;
	}

	public static void main(String[] args) {
		Time time = new Time();

		time.hour = 8;
		time.minute = 30;
		time.second = 23;
		time.set();

		String opt = "+";
		int result = time.add(10, 20, opt);

		System.out.println(result);
		System.out.println(time.hour + "시 " + time.minute + "분 " + time.second + "초");

	}

}
