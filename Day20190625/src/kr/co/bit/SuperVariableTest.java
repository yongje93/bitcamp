package kr.co.bit;

class Sawon3 {
	String name;

	public Sawon3() {
		name = "��õ��";
	}
}

class Sales3 extends Sawon3 {
	String name;

	public Sales3() {
		name = "������";
	}

	public String displayInfoLocal() {
		String name = "��¼�";
		return name;
	}

	public String displayInfoThis() {
		String name = "������";
		return this.name;
	}

	public String displayInfoSuper() {
		String name = "������";
		return super.name;
	}
}

public class SuperVariableTest {

	public static void main(String[] args) {
		Sales3 sales = new Sales3();
		System.out.println("���� �̸� = " + sales.displayInfoLocal());
		System.out.println("this �̸� = " + sales.displayInfoThis());
		System.out.println("super �̸� = " + sales.displayInfoSuper());
	}

}
