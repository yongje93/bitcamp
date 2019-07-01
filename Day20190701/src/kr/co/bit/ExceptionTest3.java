package kr.co.bit;

public class ExceptionTest3 {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		try {
			int result = 10/num;
			System.out.println(result);
		} catch (ArrayIndexOutOfBoundsException e1) {
			e1.printStackTrace();
		} catch (NumberFormatException e2) {
			e2.printStackTrace();
		} catch (ArithmeticException e3) {
			e3.printStackTrace();
		}
		System.out.println("프로그램 계속 실행됨");
	}
	
}
