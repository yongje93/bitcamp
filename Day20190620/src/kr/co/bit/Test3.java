package kr.co.bit;

public class Test3 {
	int iv;
	public static int cv;
	
	public void test1() {
		System.out.println(iv);
		System.out.println(cv);
	}
	public static void test2() {	//클래스메소드에서는 인스턴스 변수 사용 불가능
		//System.out.println(iv);
		System.out.println(cv);
	}
	
	public void instanceMethod() {
		test1();
		test2();
	}
	public static void staticMethod() {	//클래스메소드에서는 인스턴스 메소드는 호출 불가능
		//test1();
		test2();
	}
	public static void main(String[] args) {
		
	}
	
}
