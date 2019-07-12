/*	10~99사이의 난수를 2개 발생하여 합을 맞추는 게임
	총 문제는 5문제
	1문제당 점수는 20점
	틀리면 1번 더 기회를 제공한다.

	[실행결과]
	[1] 12 + 36 = XX
	틀렸다
	[1] 12 + 36 = XXX
	틀렸다...정답은 48

	[2] 10 + 15 = XX
	딩동댕
	..
	[5] 90 + 88 = xx
	틀렸다
	[5] 90 + 88 = 178
	딩동댕
	총 맞은개수는 2문제이고 점수는 40점입니다.

	또할래(Y/N) : n
	프로그램을 종료합니다.
*/
import java.util.Scanner;

class Quiz {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int answer = 0;
		int count = 0;
		int xcount = 0;
		String yn;
		while(true) {
			for(int i = 1; i <= 5; i++) {
				int random1 = (int)(Math.random()*90) + 10;
				int random2 = (int)(Math.random()*90) + 10;
				while(true) {
					System.out.print("["+i+"] "+random1 + " + " + random2 + " = ");
					answer = scan.nextInt();
					if(answer == (random1 + random2)) {
						count++;
						System.out.println("딩동댕");	
						xcount = 0;
						break;
					} else {
						if(xcount == 0) {
							System.out.println("틀렸다.");
							xcount++;
							continue;
						}
						else if(xcount == 1) {
							xcount = 0;
							System.out.println("틀렸다...정답은 " + (random1 + random2) +"이다.");
							break;
						}
					}
				 }
			}
			System.out.println("총 맞은개수는 "+ count+ "문제이고 점수는 "+(count*20) + "점입니다.");
			System.out.print("또 하시겠습니까?(y/n) ");
			yn = scan.next();
			if(yn.equals("n") || yn.equals("N")) break;
		}
		System.out.println("프로그램을 종료합니다.");
	}
}
