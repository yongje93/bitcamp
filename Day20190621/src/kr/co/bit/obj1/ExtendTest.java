package kr.co.bit.obj1;

class Parent1 extends Object {
	protected int age;

	public Parent1() { // 생성자 함수(상속이 진행 안됨)
		super();
	}

	public Parent1(int a) {
		age = a;
	}

	public void parentMethod() {
		System.out.println("부모함수");
	}
}

class Son1 extends Parent1 {
	protected int number1;

	public Son1() {
		super(); // 부모 클래스의 생성자 함수를 사용할 때 부른다.
	}

	public Son1(int n) {
		super(10);
	}
	
	public void sonMethod() {
		System.out.println("자식함수");
	}
}

public class ExtendTest {

	public static void main(String[] args) {
		Son1 son1 = new Son1();
		son1.age = 10;
		son1.parentMethod();
		son1.number1 = 100;
		son1.sonMethod();
	}

}
