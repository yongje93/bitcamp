package kr.co.bit;

public class ExceptionTest2 {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		try {
			int result = 10 / num;
			System.out.println("result = " + result);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("정수를 0으로 나눌수 없다.");
		}
		System.out.println("프로그램 계속 실행");
	}
	
}
