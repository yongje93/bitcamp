package kr.co.bit;

public class Switch_Test1 {

	public static void main(String[] args) {
		String job = args[0];
		int salary = 0;
		switch (job) {
			case "사원":
				salary = 20000000;
				break;
			case "대리":
				salary = 35000000;
				break;
			case "과장":
				salary = 50000000;
				break;
			case "부장":
				salary = 80000000;
				break;
			default:
				System.out.println("사원, 대리, 과장, 부장 중 입력하세요.");
		}
		System.out.println("당신의 연봉은 " + salary + "원 입니다.");
	}
}
