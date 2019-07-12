/*
10~99사이의 난수를 2개 발생하여 합을 맞추는 게임
총 문제는 5문제를 제공한다
1문제당 점수 20점입니다
틀리면 1번 더 기회를 제공한다

[실행결과]
[1] 12 + 36 = xx
틀렸다
[1] 12 + 36 = xxx
틀렸다...정답은 48

[2] 10 + 15 = xx
딩동뎅

[5] 90 + 88 =
틀렸다
[5] 90 + 88 = 178
딩동뎅

총 맞은개수는 2문제이고 점수는 40점입니다

또 할래(Y/N) : n
프로그램을 종료합니다
*/

import java.util.Scanner;
class Quiz_Answer {
	public static void main(String[] args) {
		int a,b,dab,score=0;
		String again;

		Scanner input = new Scanner(System.in);
		while(true) {
			score=0;

			for(int i=1; i<=5; i++){//5문제
				a = (int)(Math.random()*90) + 10;//10~99
				b = (int)(Math.random()*90) + 10;//10~99
		
				for(int j=1; j<=2; j++){//틀리면 1번 더 기회를 준다
					System.out.print("["+i+"] "+a+" + "+b+" = ");
					dab = input.nextInt();

					if(dab==a+b){
						System.out.println("맞았습니다!!!");
						score++;
						break;//for j를 벗어나라
					}else{
						if(j==2)
							System.out.println("틀렸습니다...정답은 "+(a+b));
						else
							System.out.println("틀렸습니다...");
					}
				}//for j
				System.out.println();
			}//for i
			System.out.println("총 맞은개수는 "+score+"문제이고 점수는 "+score*20+"점입니다");
			System.out.println();
			do{
				System.out.print("다시하겠습니까? (Y/N) : ");
				again = input.next();
				if(again.equals("Y") || again.equals("y") || again.equals("N") || again.equals("n")) break;			
			} while(true);
			if(again.equals("N") || again.equals("n")) break;			
		}//while
		System.out.println("프로그램을 종료합니다.");
	}
}