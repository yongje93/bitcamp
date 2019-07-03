package kr.co.bit;

public class MyThread extends Thread {
	
	public MyThread(String name) {
		super(name);
	}

	public void run() { // 스레드에서 수행할 기능 정의.
		for (int i = 0; i < 5; i++) {
			System.out.print(i);
		}
	}
	
	public static void main(String[] args) {
		MyThread myThread = new MyThread("myThread");
		myThread.start();
	}
	
}
