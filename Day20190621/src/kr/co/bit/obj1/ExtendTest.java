package kr.co.bit.obj1;

class Parent1 extends Object {
	protected int age;

	public Parent1() { // ������ �Լ�(����� ���� �ȵ�)
		super();
	}

	public Parent1(int a) {
		age = a;
	}

	public void parentMethod() {
		System.out.println("�θ��Լ�");
	}
}

class Son1 extends Parent1 {
	protected int number1;

	public Son1() {
		super(); // �θ� Ŭ������ ������ �Լ��� ����� �� �θ���.
	}

	public Son1(int n) {
		super(10);
	}
	
	public void sonMethod() {
		System.out.println("�ڽ��Լ�");
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
