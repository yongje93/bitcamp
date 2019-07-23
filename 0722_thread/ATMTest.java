import java.util.Scanner;

class ATMTest implements Runnable {
	private long depositeMoney = 100000; // �ܾ�
	private long balance; //ã���� �ϴ� �ݾ�

	public static void main(String[] args) {
		ATMTest atm = new ATMTest();	// mom, son �� ���� �����ϱ� ���ؼ� 
		//������ ����
		Thread mom = new Thread(atm, "����");
		Thread son = new Thread(atm, "�Ƶ�");
		//������ ����
		mom.start();
		son.start();
	}

	@Override
	//public synchronized void run() {	//����ȭO
	public void run() {
		//synchronized(this) {			//����ȭO
		synchronized(ATMTest.class) {	//����ȭO
			System.out.println("\n" + Thread.currentThread().getName() + "�� �ȳ��ϼ���");
			
			Scanner scan = new Scanner(System.in);
			System.out.print("ã���� �ϴ� �ݾ� �Է� : ");
			balance = scan.nextLong();
			
			withDraw();//ȣ��
		}
	}

	public void withDraw(){
		if(depositeMoney >= balance){
			if(balance%10000==0){
				depositeMoney -= balance;
				System.out.println("�ܾ��� "+depositeMoney+"�� �Դϴ�");
			}else
				System.out.println("���� ������ �Է��ϼ���");

		}else
			System.out.println("�ܾ� �ʰ�");
	}
}