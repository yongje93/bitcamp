package kr.co.bit;

import java.util.Scanner;

public class JuExecutor1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("ÁÖ¹®ÇÏ¼¼¿ä y/n");
			char ju = input.next().charAt(0);
			if (ju == 'y' || ju == 'Y') {
				System.out.println("ÁÖ¹®¼±ÅÃ");
				System.out.println("¸Ş´º 1.Â¥Àå¸é 2.Â«»Í 3.ÅÁ¼öÀ°");
				int menu = input.nextInt();
				if (menu == 1) {
					System.out.println("Â¥Àå¸é ¼±ÅÃ");
					System.out.println("Â¥Àå¸é °ö¹è±â y/n");
					char gob = input.next().charAt(0);
					if (gob == 'y' || gob == 'Y') {
						System.out.println("Â¥Àå¸é °ö¹è±â");
					} else {
						System.out.println("Â¥Àå¸é º¸Åë");
					}
				} else if (menu == 2) {
					System.out.println("Â«»Í ¼±ÅÃ");
					System.out.println("Â«»Í °ö¹è±â y/n");
					char gob = input.next().charAt(0);
					if (gob == 'y' || gob == 'Y') {
						System.out.println("Â«»Í °ö¹è±â");
					} else {
						System.out.println("Â«»Í º¸Åë");
					}
				} else if (menu == 3) {
					System.out.println("ÅÁ¼öÀ° ¼±ÅÃ");
					System.out.println("¸Ş´º 1.´ë 2.Áß 3.¼Ò");
					int tang = input.nextInt();
					if (tang == 1) {
						System.out.println("ÅÁ¼öÀ° ´ë");
					} else if (tang == 2) {
						System.out.println("ÅÁ¼öÀ° Áß");
					} else if (tang == 3) {
						System.out.println("ÅÁ¼öÀ° ¼Ò");
					}
				} else {
					System.out.println("1,2,3 Áß¿¡ ¼±ÅÃÇÏ¼¼¿ä.");
				}
			} else {
				System.out.println("ÁÖ¹®Ãë¼Ò");
				break;
			}
		}
	}

}
