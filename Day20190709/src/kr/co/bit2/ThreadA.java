package kr.co.bit2;

public class ThreadA extends Thread {
	private WorkObject obj;

	public ThreadA(WorkObject obj) {
		this.obj = obj;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			try {
				obj.methodA();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
