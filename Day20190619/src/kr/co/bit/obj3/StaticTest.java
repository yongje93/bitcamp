package kr.co.bit.obj3;

public class StaticTest {
	static int number1;	// ����ƽ����(Ŭ��������)
	public int number2; // �ν��Ͻ����� (������ �Լ����� �ʱ�ȭ�� �̷�������)
	static {
		number1 = 0;	
	}
	
	public StaticTest() {
		number2 = 0;
	}
	
	public static void main(String[] args) {	
		StaticTest staticTest = new StaticTest();	// �ν��Ͻ� ����
	}
	
}
