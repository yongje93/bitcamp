package kr.co.bit;

public class Example10 {
	public static void main(String[] args) throws InterruptedException {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		
		threadA.start();
		threadB.start();
		
		Thread.sleep(3000);
		threadA.setWork(false);
		
		Thread.sleep(3000);
		threadA.setWork(true);
		
		Thread.sleep(3000);
		threadA.setStop(true);
		threadB.setStop(true);
	}
}
