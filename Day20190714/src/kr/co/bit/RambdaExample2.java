package kr.co.bit;

interface MyFunctionalInterface2 {
	public int method2(int x, int y);
}

public class RambdaExample2 {

	public static void main(String[] args) {
		MyFunctionalInterface2 fi2;
		fi2 = (x, y) -> {
			int result = x + y;
			return result;
		};
		System.out.println(fi2.method2(2, 5));

		fi2 = (x, y) -> x + y;
		System.out.println(fi2.method2(2, 5));

		fi2 = (x, y) -> sum(x, y);
		System.out.println(fi2.method2(2, 5));
	}

	public static int sum(int x, int y) {
		return (x + y);
	}

}
