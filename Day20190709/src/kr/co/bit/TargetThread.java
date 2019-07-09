package kr.co.bit;

public class TargetThread extends Thread { // 실질적으로 일이 일어나는 부분.

	@Override
	public void run() {
		for(long i = 0; i < 1000000000; i++) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 	
		
	}

}
