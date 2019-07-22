import java.lang.Thread;

class SnackTest extends Thread {
	private String str;

	public SnackTest(String str) {
		this.str = str;
	}
	
	@Override
	public void run() {	//thread ���¿��� call back�̴�.
		for(int i = 1; i <=5; i++) {
			System.out.println(str+"\t i = " + i + "\t" + Thread.currentThread());
		}
	}
	public static void main(String[] args) {
		SnackTest aa = new SnackTest("�����");
		SnackTest bb = new SnackTest("Ȩ����");
        SnackTest cc = new SnackTest("��īĨ");
		
		//������ �̸� ����
		aa.setName("�����");
		bb.setName("Ȩ����");
        cc.setName("��īĨ");

		//�켱����(1~10)
		//bb.setPriority(10); ���� ���� �켱����
		bb.setPriority(Thread.MAX_PRIORITY);	//10
		cc.setPriority(Thread.MIN_PRIORITY);	//1
		aa.setPriority(Thread.NORM_PRIORITY);	//5
        

		aa.start();	//������ ����. ������ ����(run()) �����ϸ� �ü���� �˾Ƽ� run()
		try {
			aa.join();	//������ ���̱�.	����ó�� �ʿ���.
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		bb.start();
		cc.start();
		    
	}
}
