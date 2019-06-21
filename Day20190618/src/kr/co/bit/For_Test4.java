package kr.co.bit;

public class For_Test4 {

	public static void main(String[] args) {
		int sum = 0;
		String exp = "";
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				sum += i;
				exp += (i == 2) ? "" + i : "+" + i;
			}
		}
		System.out.println(exp+ "=" + sum);
	}

}
