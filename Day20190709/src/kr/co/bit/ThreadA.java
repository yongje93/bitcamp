package kr.co.bit;

public class ThreadA extends Thread {
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
				System.out.println("ThreadA 작업중");
			} else {
				Thread.yield();
			}
		}
		System.out.println("Thread 종료");
	}
	
}
