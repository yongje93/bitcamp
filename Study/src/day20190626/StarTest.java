package day20190626;

public class StarTest {
	public static void main(String[] args) {

		 for (int i = 0; i < 5; i++) {
	            for (int j = 1; j <= i; j++) {
	                System.out.print(" ");
	            }
	            for (int k = 9 ; k >= i*2+1; k--) {
	            	System.out.print("*");
	            }
	            System.out.println();
		 }

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = 5; k > i; k--) {
				System.out.print("*");
			}
			System.out.println();
			
		}

	}
}
