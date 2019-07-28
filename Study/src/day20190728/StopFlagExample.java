package day20190728;

public class StopFlagExample {
	public static void main(String[] args) {
		PrintThread1 printThread = new PrintThread1();
		printThread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		printThread.setStop(true);
	}
}

class PrintThread1 extends Thread {
	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while (!stop)
			System.out.println("실행중");
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}

}
