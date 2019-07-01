package kr.co.bit;

public class ExceptionTest4 {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		try {
			int result = 10 / num;
			System.out.println(result);
		} catch (ArrayIndexOutOfBoundsException e1) {
			e1.printStackTrace();
		} catch (NumberFormatException e2) {
			e2.printStackTrace();
		} catch (ArithmeticException e3) {
			e3.printStackTrace();
		} finally {
			System.out.println("예외가 일어나도 수행 / 안일어나도 수행");
		}
	}

}
