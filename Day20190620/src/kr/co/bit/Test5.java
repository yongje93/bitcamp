package kr.co.bit;

public class Test5 {
	private int number1;
	private int number2;

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

	public Test5(int number1, int number2) {
		super();
		this.number1 = number1;
		this.number2 = number2;
	}

	public Test5() {
		super();
	}

	@Override
	public String toString() {
		return "Test5 [number1=" + number1 + ", number2=" + number2 + "]";
	}

	public static void main(String[] args) {
		Test5 test5 = new Test5();
		Test5 test6 = new Test5(100,200);
	}
}
