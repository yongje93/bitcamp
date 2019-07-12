/*
숫자 맞추기 게임
1~100 사이의 난수를 발생하여 맞추는 게임
[실행결과]
1~100 사이의 난수를 발생하였습니다. 87
숫자 입력 : 50
50보다 큽니다.

숫자 입력 : 90
90보다 작습니다.
..
.

숫자 입력 : 87
XX번 만에 맞추셨습니다.
*/
import java.util.Scanner;

class NumberGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number;
		String yn;
		while(true) {
			int random = (int)(Math.random()*100) + 1;			
			int count = 0;
			System.out.println(random);
			while(true) {
				System.out.print("숫자 입력 : ");
				number = scan.nextInt();
				count++;
				if(random > number) {
					System.out.println(number+"보다 큽니다.");
				} else if(random < number) {
					System.out.println(number+"보다 작습니다.");
				} else 
					break;
			}
			System.out.println(count+"번 만에 맞추셨습니다.");
			System.out.print("또 하시겠습니까?(y/n) ");
			yn = scan.next();
			if(yn.equals("n") || yn.equals("N")) break;
		}
		System.out.println("프로그램을 종료합니다.");
	}
}
