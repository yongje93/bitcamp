package day20190713;

public class MultiFor4 {

	public static void main(String[] args) {
		int i, j, k;
		for (k = 2; k < 9; k += 3) {
			for (j = 1; j < 10; j++) {
				for (i = k; i < k + 3; i++) {
					if (i == 10) break;
					System.out.print(i +" * " + j + " = " + (i*j) +"\t");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
