/*
주차관리 프로그램
만약에 주차되어있으면 true, 차가 없으면 false

[실행결과]
**************
	1.입차
	2.출차
	3.리스트 보기
	4.끝
*************
	번호: 4
	프로그램 종료
1번일 경우
위치 입력 : 3	 배열로는 2번방
이미 주차 되어있습니다.
또는
위치 입력 : 3
3번 위치 입차

2번일 경우
위치 입력 : 3	
주차되어 있는 차가 없습니다.
또는
위치 입력 : 3
3번 위치 출차

3번일 경우
1 위치 : false
2 위치 : false
3 위치 : false
4 위치 : false
5 위치 : false
*/
import java.util.Scanner;

class Car {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean[] ar = new boolean[5]; // 주차장 배열
		int protocol; // 입력 번호
		int park; // 주차 위치

		while (true) {
			System.out.println();
			System.out.println("**********************");
			System.out.println("\t1.입차\n\t2.출차\n\t3.리스트 보기\n\t4.끝");
			System.out.println("**********************");
			System.out.print("번호 입력: ");
			protocol = scan.nextInt();
			System.out.println();

			if (protocol == 1) {
				System.out.print("위치 입력: ");
				park = scan.nextInt();
				if (ar[park - 1]) { // 주차가 되어있을경우	// boolean형은 == 안씀. 그자체가 true false
					System.out.println("이미 주차 되어있습니다.");
				} else { // 주차가 안되어있을경우
					ar[park - 1] = true;
					System.out.println(park + "번 위치 입차");
				}
			} else if (protocol == 2) {
				System.out.print("위치 입력: ");
				park = scan.nextInt();
				if (ar[park - 1]) { // 주차가 되어있을경우
					ar[park - 1] = false;
					System.out.println(park + "번 위치 출차");
				} else { // 주차가 안되어있을경우
					System.out.println("주차되어 있는 차가 없습니다.");
				}
			} else if (protocol == 3) {
				for (int i = 0; i < ar.length; i++) {
					System.out.println((i + 1) + " 위치 : " + ar[i]);
				}
			} else if (protocol == 4) {
				System.out.println("프로그램 종료");
				System.exit(0);
			} else {
				System.out.println("1 ~ 4 중 하나만 고르세요.");
			}
		}
	}
}
