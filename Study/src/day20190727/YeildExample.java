package day20190727;

public class YeildExample {
	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		
		threadA.start();
		threadB.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		threadA.setWork(false);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		threadA.setWork(true);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		threadA.setStop(true);
		threadB.setStop(true);
	}
}
