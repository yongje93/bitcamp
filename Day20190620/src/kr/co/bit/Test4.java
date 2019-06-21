package kr.co.bit;

public class Test4 {
	private int number1;
	private int number2;

	public Test4() {
		number1 = 100;
		number2 = 200;
	}

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	public static void main(String[] args) {
		Test4 test4 = new Test4();
		System.out.println(test4.number1);
		System.out.println(test4.number2);
		test4.setNumber1(1000);
		test4.setNumber2(2000);
		System.out.println(test4.getNumber1());
		System.out.println(test4.getNumber2());
	}
}
