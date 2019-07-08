package kr.co.bit;

public class Service {
	// 제어의 역전.
	@PrintAnnotation
	public void method1() {
		System.out.println("실행내용1");
	}

	@PrintAnnotation("*")
	public void method2() {
		System.out.println("실행내용2");
	}

	@PrintAnnotation(value = "#", number = 20)
	public void method3() {
		System.out.println("실행내용3");
	}
}
