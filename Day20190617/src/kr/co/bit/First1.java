package kr.co.bit;

public class First1 {
	public static void main(String[] args) {
		//byte 1����Ʈ(8��Ʈ) ������ (-128~127�� ����)
		byte number1 = 127;
		System.out.println(number1);
		//short 2����Ʈ(16��Ʈ) ������ (-32768~32767�� ����)
		short number2 = 32767;
		System.out.println(number2);
		//int 4����Ʈ(32��Ʈ) ������ 
		int number3 = 30000;
		System.out.println(number3);
		//long 8����Ʈ(64��Ʈ) ������
		long number4 = 400000;
		System.out.println(number4);
		//char ������
		char alpa = 'A';
		System.out.println(alpa);
		//string ���ڿ�
		String str = "�ȳ��ϼ���";
		System.out.println(str);
		//float 4����Ʈ �Ǽ���
		float sil = 1.5f;	
		System.out.println(sil);
		//�ڹٴ� �Ҽ����� 8����Ʈ(double)�� �������� ����� ������ float�� ���� ���� f�� �ٿ�����Ѵ�.
		//double 8����Ʈ �Ǽ���
		double sil1 = 1.5;
		System.out.println(sil1);
		//boolean ���� 1����Ʈ(��,����)
		boolean logic = true;
		System.out.println(logic);
		logic = false;
		System.out.println(logic);
	}
}
