package kr.co.bit;

public class ParameterTest {

	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		System.out.println("main():x = " + d.x);
		change(d.x);
		System.out.println("After Change(d.x)");
		System.out.println("main():x = " + d.x);
	}

	public static void change(int x) {
		x = 1000;
		System.out.println("Cahnge():x = " + x);
	}

}
