package kr.co.bit;

class MyThread1 extends Thread {
	public MyThread1(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i <= 20; i++) {
			try {
				System.out.print(currentThread().getName());
				sleep(1000);
				for (int j = 1; j <= i; j++) {
					System.out.print("$");
				}
				System.out.println();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadTest1 {
	public static void main(String[] args) {	// 병행처리.
		MyThread1 myThread = new MyThread1("myThread");	
		myThread.start();
		MyThread1 myThread1 = new MyThread1("myThread1");
		myThread1.start();
		
	}
}
