import java.util.Scanner;

class ATMTest implements Runnable {
	private long depositeMoney = 100000; // 잔액
	private long balance; //찾고자 하는 금액

	public static void main(String[] args) {
		ATMTest atm = new ATMTest();	// mom, son 이 같이 접근하기 위해서 
		//스레드 생성
		Thread mom = new Thread(atm, "엄마");
		Thread son = new Thread(atm, "아들");
		//스레드 시작
		mom.start();
		son.start();
	}

	@Override
	//public synchronized void run() {	//동기화O
	public void run() {
		//synchronized(this) {			//동기화O
		synchronized(ATMTest.class) {	//동기화O
			System.out.println("\n" + Thread.currentThread().getName() + "님 안녕하세요");
			
			Scanner scan = new Scanner(System.in);
			System.out.print("찾고자 하는 금액 입력 : ");
			balance = scan.nextLong();
			
			withDraw();//호출
		}
	}

	public void withDraw(){
		if(depositeMoney >= balance){
			if(balance%10000==0){
				depositeMoney -= balance;
				System.out.println("잔액은 "+depositeMoney+"원 입니다");
			}else
				System.out.println("만원 단위로 입력하세요");

		}else
			System.out.println("잔액 초과");
	}
}