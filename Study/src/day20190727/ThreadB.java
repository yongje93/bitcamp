package day20190727;

public class ThreadB extends Thread {
	private boolean stop = false;
	private boolean work = true;

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public boolean isWork() {
		return work;
	}

	public void setWork(boolean work) {
		this.work = work;
	}
	
	@Override
	public void run() {
		while(!stop) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(work) {
				System.out.println("ThreadB 작업 내용");
			} else {
				Thread.yield();
			}
		}
		System.out.println("ThreadB 종료");
	}

}
