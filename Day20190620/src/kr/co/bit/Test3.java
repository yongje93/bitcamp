package kr.co.bit;

public class Test3 {
	int iv;
	public static int cv;
	
	public void test1() {
		System.out.println(iv);
		System.out.println(cv);
	}
	public static void test2() {	//Ŭ�����޼ҵ忡���� �ν��Ͻ� ���� ��� �Ұ���
		//System.out.println(iv);
		System.out.println(cv);
	}
	
	public void instanceMethod() {
		test1();
		test2();
	}
	public static void staticMethod() {	//Ŭ�����޼ҵ忡���� �ν��Ͻ� �޼ҵ�� ȣ�� �Ұ���
		//test1();
		test2();
	}
	public static void main(String[] args) {
		
	}
	
}
