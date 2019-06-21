package kr.co.bit;

public class For_Test3 {

	public static void main(String[] args) {
		int num = 16;
		int sum = 0;
		String exp = "";
		for (int i = num; i >= 1; i--) {
			sum += i;
			exp += (i == num) ? "" + i : "+" + i;
		}
		System.out.println(exp + "=" + sum);
	}

}
