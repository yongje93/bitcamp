package kr.co.bit;

public class Example11 {
	public static void main(String[] args) throws InterruptedException {
		SumThread st = new SumThread();
		st.start();
		
		st.join();	// join 메소드가 호출한 스레드가 일시 정지 상태가된다.
		System.out.println("1~100합 : " + st.getSum());
	}
}
