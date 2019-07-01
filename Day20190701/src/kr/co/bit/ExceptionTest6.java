package kr.co.bit;

public class ExceptionTest6 {
	public void exceptionMethod() throws Exception {
		throw new Exception();
	}
	
	public static void main(String[] args) {
		ExceptionTest6 et6 = new ExceptionTest6();
		try {
			et6.exceptionMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
