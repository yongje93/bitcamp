package kr.co.bit;

public class For_Test2 {

	public static void main(String[] args) {
		int sum = 0;
		String exp = "";

		for (int i = 0; i <= 10; i++) {
			sum += i;
			exp += (i == 0) ? "" + i : "+" + i;
		}
		System.out.println(exp + "=" + sum);
	}

}
