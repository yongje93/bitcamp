package kr.co.bit.obj3;

public class AirCon {
	// static�� ������ new �����ڰ� ��� �ٷ� �̿��� �����ϴ�.
	
	// ������ �������
	String company;
	String color;
	int price;
	int size;
	int temp;

	/*
	 * public AirCon() { // ������ �Լ� constructor // 0���� �ʱ�ȭ ����.
	 * 		company= null; 
	 * 		color = null; 
	 * 		price = 0; 
	 * 		size = 0; 
	 * 		temp = 0; 
	 * }
	 */

	public void powerOn() {
		System.out.println("������ �״�.");
	}

	public void powerOff() {
		System.out.println("������ ����.");
	}

	public void tempUp() {
		temp++;
	}

	public void tempDown() {
		temp--;
	}
}
