class Synchronized extends Thread {
	private static int count;
	
	public static void main(String[] args) {
		Synchronized aa = new Synchronized();	//스레드 생성
        Synchronized bb = new Synchronized();
		Synchronized cc = new Synchronized();
		aa.setName("aa");
		bb.setName("bb");
		cc.setName("cc");
		aa.start();	//스레드 시작
		bb.start();
		cc.start();
	}
	public void run() {
//	public synchronized void run() {	//동기화X
	//	synchronized(this) {	//동기화X 객체가 3개이니까 this가 다다름
		synchronized(Synchronized.class) {
			for(int i=1; i<=5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName()+" : "+count);
				
				try {
					Thread.sleep(100);
				} catch(InterruptedException e){ e.printStackTrace(); }
			}
		}
	}
}
