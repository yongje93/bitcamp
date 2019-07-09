package kr.co.bit;

public class Calculator2 {
	private int memeoy; // 메모리 자원

	public int getMemeoy() {
		return memeoy;
	}
	
	//synchronized 동기화. 동시 접근이 되는것을 막는다.
	public synchronized void setMemory(int memory) throws InterruptedException {
		this.memeoy = memory;
		Thread.sleep(2000);
		System.out.println(Thread.currentThread().getName() + " : " + this.memeoy);
	}

}
