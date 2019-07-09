package kr.co.bit2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Example02 {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);		// 스레드 개수를 정해줌. 정해진 개수 이상은 스레드가 생성이 안되서 안전하다.

		for (int i = 0; i < 10; i++) {
			Runnable runnable = () -> {
				ThreadPoolExecutor tpe = (ThreadPoolExecutor) es;
				int poolSize = tpe.getPoolSize();
				String threadName = Thread.currentThread().getName();
				System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName);
				//int value = Integer.parseInt("")
			};
			es.execute(runnable);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		es.shutdown();
	}
}
