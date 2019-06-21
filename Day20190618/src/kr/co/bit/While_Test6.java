package kr.co.bit;

public class While_Test6 {

	public static void main(String[] args) {
		int i = 2;
		int j = 1;
		while (i <= 9) {
			while (j <= 9) {
				System.out.print(i + " * " + j + " = " + i * j +" ");
				j++;
			}
			i++;
			j = 1;
			System.out.println();
		}

	}

}
