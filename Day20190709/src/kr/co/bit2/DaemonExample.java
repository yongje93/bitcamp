package kr.co.bit2;

public class DaemonExample {
	public static void main(String[] args) throws InterruptedException {
		AutoSaveThread ast = new AutoSaveThread();
		ast.setDaemon(true);	// 데몬 스레드는 메인 스레드가 종료되면 같이 종료가 된다.
		ast.start();
		Thread.sleep(3000);
		System.out.println("메인 메소드 종료");
	}
}
