package kr.co.bit;

public class ExceptionTest6 {
	public void exceptionMethod() throws Exception {
		throw new Exception();
//		try {
//			throw new Exception();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println("�޼ҵ忡�� ����ó��");
//		}
	}
	
	public static void main(String[] args) {
		ExceptionTest6 et6 = new ExceptionTest6();
		try {
			et6.exceptionMethod();
		} catch (Exception e) {
			System.out.println("ȣ���� �޼ҵ忡�� ����ó����");
		}
	}
}
