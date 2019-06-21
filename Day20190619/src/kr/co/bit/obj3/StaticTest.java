package kr.co.bit.obj3;

public class StaticTest {
	static int number1;	// 스태틱변수(클래스변수)
	public int number2; // 인스턴스변수 (생성자 함수에서 초기화가 이루어줘야함)
	static {
		number1 = 0;	
	}
	
	public StaticTest() {
		number2 = 0;
	}
	
	public static void main(String[] args) {	
		StaticTest staticTest = new StaticTest();	// 인스턴스 변수
	}
	
}
