package kr.co.bit;

public class JuExecuter {

	public static void main(String[] args) {
		System.out.println("주문선택 y/n");
		char ju = args[0].charAt(0);	//charAt을 통해서 한문자로 가져온다. ""에서 ''로
		if(ju == 'y' || ju == 'Y') {	//주문선택
			System.out.println("주문선택");
			System.out.println("메뉴 1.짜장면 2.짬뽕 3.탕수육");
			int menu = Integer.parseInt(args[1]);
			if(menu == 1) {
				System.out.println("짜장면 선택");
				System.out.println("짜장면 곱배기 y/n");
				char gob = args[2].charAt(2);
				if(gob=='y'||gob=='Y') {
					System.out.println("짜장면 곱배기 선택");
				} else {
					System.out.println("짜장면 보통 선택");
				}
			} else if(menu == 2) {
				System.out.println("짬뽕 선택");
				char gob = args[2].charAt(2);
				if(gob=='y'||gob=='Y') {
					System.out.println("짬뽕 곱배기 선택");
				} else {
					System.out.println("짬뽕 보통 선택");
				}
			} else if(menu == 3) {
				System.out.println("탕수육 선택");
				System.out.println("탕수육 1.대 2.중 3.소");
				int tang = Integer.parseInt(args[2]);
				if(tang == 1) {
					System.out.println("탕수육 대");
				} else if (tang == 2) {
					System.out.println("탕수육 중");
				} else if (tang == 3) {
					System.out.println("탕수육 소");
				} else {
					System.out.println("탕수육 대중소 선택");
				}
			} else {
				System.out.println("1,2,3 중에 선택하세요.");
			}
		} else {	//주문취소
			System.out.println("주문취소");
		}
		
	}

}
