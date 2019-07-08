package kr.co.bit;

//@MyAnnotation1("aaa")	//value일때 값이 하나면 생략가능
public class Example {
	int a;
	int b;

	// @MyAnnotation1(value ="bbb", elemName2 = 4) //복수일때는 value를 표시해줘야됨
	public Example(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	@MyAnnotation1("ccc") // 특정한 영역에만 사용가능하도록 설정한거.
	public void method1() {

	}

	public void method2(int a, int b) {

	}

	public static void main(String[] args) {

	}

}
