package kr.co.bit;

import java.util.Scanner;

public class JuExecuter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("주문하세요. yes/no");
			String ju = input.next();
			if (ju.equals("yes") || ju.equals("YES")) {
				System.out.println("주문선택");
				System.out.println("메뉴 1.짜장면 2.짬뽕 3.탕수육");
				int menu = input.nextInt();
				if (menu == 1) {
					System.out.println("짜장면선택");
					System.out.println("곱배기 선택. yes/no");
					String gob = input.next();
					if (gob.equals("yes") || gob.equals("YES")) {
						System.out.println("짜장면 곱배기 선택");
					} else {
						System.out.println("짜장면 보통 선택");
					}
				} else if (menu == 2) {
					System.out.println("짬뽕선택");
					System.out.println("곱배기 선택. yes/no");
					String gob = input.next();
					if (gob.equals("yes") || gob.equals("YES")) {
						System.out.println("짜장면 곱배기 선택");
					} else {
						System.out.println("짜장면 보통 선택");
					}
				} else if (menu == 3) {
					System.out.println("탕수육선택");
					System.out.println("메뉴 1.대 2.중 3.소");
					int tang = input.nextInt();
					if(tang == 1) { 
						System.out.println("탕수육 대");
					} else if (tang == 2) {
						System.out.println("탕수육 중");
					} else if (tang == 3) {
						System.out.println("탕수육 소");
					}
				}
			} else {
				System.out.println("주문취소");
				break;
			}
		}

	}

}
