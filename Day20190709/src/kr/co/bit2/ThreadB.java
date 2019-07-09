package kr.co.bit2;

public class ThreadB extends Thread {
	private WorkObject obj;

	public ThreadB(WorkObject obj) {
		this.obj = obj;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			try {
				obj.methodB();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
