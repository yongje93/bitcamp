package kr.co.bit.obj1;

public class Son extends Parent {
	protected int number1;

	public Son() {

	}

	public void sonMethod() {
		System.out.println("�ڽ��Լ�");
	}
	
	public static void main(String[] args) {
		Son son = new Son();
		son.age = 10;
		son.parentMethod();
		System.out.println("�θ��� ���̴� " + son.age);
		son.number1 = 100;
		son.sonMethod();
		System.out.println("������ ���̴� " + son.number1);
	}
}
