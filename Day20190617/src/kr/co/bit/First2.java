package kr.co.bit;

public class First2 {

	public static void main(String[] args) {
		//�ڵ�����ȯ(�����Ϸ��� �ڵ�����)
		byte number1 = 10;
		int number2 = number1;
		//��������ȯ
		int number3 = 150;
		byte number4 = (byte)number3;
		System.out.println(number4);
		
		byte number5 = 50;
		byte number6 = 40;
		int sum = number5 + number6;	
		System.out.println(sum);
		
		char c1 = 'A';	//�ƽ�Ű�ڵ忡�� 65��
		int sum1 = c1 + 1;
		System.out.println(sum1);
		
		int d1 = 65;
		System.out.println((char)d1);
		
		char e1= 'a';	//�ƽ�Ű�ڵ忡�� 97��
		int sum2 = e1 + 1;
		System.out.println(sum2);
	
	}

}
