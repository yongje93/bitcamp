package kr.co.bit;

public class Test2 {
	public int max(int a, int b) {
		int result = 0;
		if (a > b)
			result = a;
		else
			result = b;

		return result;
	}

	public static void main(String[] args) {
		Test2 test2 = new Test2();
		int result = test2.max(10, 20);
		System.out.println(result);
	}
}
