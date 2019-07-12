/* 가위 바위 보 게임.
	1: 가위 
	2: 바위
	3: 보
	컴퓨터가 1~3의 난수를 발생한다. 
	기본금액은 10,000원
	금액이 0원이거나 마이너스면 금액을 다시 입력

	[실행결과]
	가위, 바위, 보(1~3) : 1 (System.in.read() 사용)
	배팅 금액: 3000
	Enter를 치세요...
	
	컴퓨터 : 바위, 나 가위
	졌따
	당신의 금액은 7000원입니다.
	
	insert coin(y/n) : n
	프로그램을 종료합니다.

	insert coin(y/n) : y
	얼마를 충전할까요? 
*/
import java.util.Scanner;

class Game {
	public static void main(String[] args) throws java.io.IOException {
		Scanner scan = new Scanner(System.in);
		int com, user;
		int money = 10000;
		int battingMoney;
		int chargeMoney;
		String yn;
	
		while(true) {
			com = (int)(Math.random()*3) + 1;	
			
			System.out.print("가위, 바위, 보 (1~3) : ");
			user = System.in.read()-'0';
			do {
				System.out.print("배팅 금액 : ");
				battingMoney = scan.nextInt();
				System.out.print("Enter를 치세요...");
				System.in.read();
				System.in.read();
				if(money > battingMoney) {
					break;
				}
			} while(money < battingMoney);

			if(com == 1) {	//가위
				if(user == 1) { //가위
					System.out.println("컴퓨터 : 가위, 나 : 가위");
					System.out.println("비겼다.");
				} else if(user == 2) { //바위
					System.out.println("컴퓨터 : 가위, 나 : 바위");
					System.out.println("이겼다.");
					money+=battingMoney;
				} else if(user == 3) { //보
					System.out.println("컴퓨터 : 가위, 나 : 보");
					System.out.println("졌다.");
					money-=battingMoney;
				}
			} else if (com == 2) {	//바위
				if(user == 1) { //가위
					System.out.println("컴퓨터 : 바위, 나 : 가위");
					System.out.println("졌다.");
					money-=battingMoney;
				} else if(user == 2) { //바위
					System.out.println("컴퓨터 : 바위, 나 : 바위");
					System.out.println("비겼다.");
				} else if(user == 3) { //보
					System.out.println("컴퓨터 : 바위, 나 : 보");
					System.out.println("이겼다.");
					money+=battingMoney;
				}
			} else if (com == 3) {	//보
				if(user == 1) { //가위
					System.out.println("컴퓨터 : 보, 나 : 가위");
					System.out.println("이겼다.");
					money+=battingMoney;
				} else if(user == 2) { //바위
					System.out.println("컴퓨터 : 보, 나 : 바위");
					System.out.println("졌다.");
					money-=battingMoney;
				} else if(user == 3) { //보
					System.out.println("컴퓨터 : 보, 나 : 보");
					System.out.println("비겼다.");
				}
			}
			System.out.println("당신의 금액은 : " + money+ "원 입니다.");
			System.out.println();
			if(money <= 0) {
				System.out.print("insert coin(y/n) : ");
				yn = scan.next();
				if(yn.equals("n") || yn.equals("N")) break;
				else if(yn.equals("y") || yn.equals("Y")) {
					System.out.print("얼마를 충전할까요? ");
					chargeMoney = scan.nextInt();
					money += chargeMoney;
				}
			}
		}//while
		System.out.println("프로그램을 종료합니다.");
	}
}
