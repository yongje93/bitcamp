package kr.co.bit.obj1;

public class Son extends Parent {
	protected int number1;

	public Son() {

	}

	public void sonMethod() {
		System.out.println("자식함수");
	}
	
	public static void main(String[] args) {
		Son son = new Son();
		son.age = 10;
		son.parentMethod();
		System.out.println("부모의 나이는 " + son.age);
		son.number1 = 100;
		son.sonMethod();
		System.out.println("손자의 나이는 " + son.number1);
	}
}
