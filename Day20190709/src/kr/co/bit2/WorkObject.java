package kr.co.bit2;

public class WorkObject {
	public synchronized void methodA() throws InterruptedException {
		System.out.println("ThreadA의 methodA() 작업 실행");
		notify();	// 해당 메소드를 runnable 상태로 만들어줌 (상대방을 wait시킴)
		wait();		
	}
	
	public synchronized void methodB() throws InterruptedException {
		System.out.println("ThreadB의 methodB() 작업 실행");
		notify();
		wait();
	}
}
