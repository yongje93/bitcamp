package kr.co.bit;

public class ThreadB extends Thread {
	private boolean stop = false;
	private boolean work = true;
	public boolean isStop() {return stop;}
	public void setStop(boolean stop) {this.stop = stop;}
	public boolean isWork() {return work;}	
	public void setWork(boolean work) {this.work = work;}
	
	@Override
	public void run() {
		while(!stop) {
			try { Thread.sleep(500);} catch (InterruptedException e) {	}
			if(work) {
				System.out.println("ThreadB 작업중");
			} else {
				Thread.yield();	// 다른 스레드에게 실행을 양보하고 실행 대기 상태
			}
		}
		System.out.println("Thread 종료");
	}
	
}

