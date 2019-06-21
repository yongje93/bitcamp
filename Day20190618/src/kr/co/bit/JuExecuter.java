package kr.co.bit;

public class JuExecuter {
	public static void main(String[] args) {
		System.out.println("주문하세요. y/n");
		char ju = 'y';
		if (ju == 'y' || ju == 'Y') {
			System.out.println("주문선택");
			System.out.println("메뉴 1.짜장면 2.짬뽕 3.탕수육");
			int menu = 1;
			switch(menu) {	//중첩 switch는 잘 안씀.
				case 1:
					System.out.println("짜장면 선택");
					System.out.println("짜장면 곱배기 y/n");
					char gob = 'y';
					if(gob == 'y' || gob == 'Y') {
						System.out.println("짜장면 곱배기 선택");
					} else {
						System.out.println("짜장면 보통 선택");
					}
					break;
				case 2:
					System.out.println("짬뽕 선택");
					System.out.println("짬뽕 곱배기 y/n");
					gob = 'y';
					if(gob == 'y' || gob == 'Y') {
						System.out.println("짬뽕 곱배기 선택");
					} else {
						System.out.println("짬뽕 보통 선택");
					}
					break;
				case 3:
					System.out.println("탕수육 선택");
					System.out.println("1.대 2.중 3.소 선택");
					int tang = 1;
					switch(tang) {
						case 1:
							System.out.println("탕수육 대");
							break;
						case 2:
							System.out.println("탕수육 중");
							break;
						case 3:
							System.out.println("탕수육 소");
							break;
						default:
							System.out.println("1,2,3 중에 선택하세요.");
					}
					break;
				default:
					System.out.println("1, 2, 3 중에 선택하세요.");
			}
		} else {
			System.out.println("주문취소");
		}
	}
}
