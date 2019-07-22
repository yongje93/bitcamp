import java.lang.Thread;

class SnackTest extends Thread {
	private String str;

	public SnackTest(String str) {
		this.str = str;
	}
	
	@Override
	public void run() {	//thread 상태여야 call back이다.
		for(int i = 1; i <=5; i++) {
			System.out.println(str+"\t i = " + i + "\t" + Thread.currentThread());
		}
	}
	public static void main(String[] args) {
		SnackTest aa = new SnackTest("새우깡");
		SnackTest bb = new SnackTest("홈런볼");
        SnackTest cc = new SnackTest("포카칩");
		
		//스레드 이름 변경
		aa.setName("새우깡");
		bb.setName("홈런볼");
        cc.setName("포카칩");

		//우선순위(1~10)
		//bb.setPriority(10); 가장 높은 우선순위
		bb.setPriority(Thread.MAX_PRIORITY);	//10
		cc.setPriority(Thread.MIN_PRIORITY);	//1
		aa.setPriority(Thread.NORM_PRIORITY);	//5
        

		aa.start();	//스레드 시작. 스레드 실행(run()) 시작하면 운영체제가 알아서 run()
		try {
			aa.join();	//스레드 죽이기.	예외처리 필요함.
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		bb.start();
		cc.start();
		    
	}
}
