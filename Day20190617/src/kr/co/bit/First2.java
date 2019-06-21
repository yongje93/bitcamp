package kr.co.bit;

public class First2 {

	public static void main(String[] args) {
		//자동형변환(컴파일러가 자동으로)
		byte number1 = 10;
		int number2 = number1;
		//강제형변환
		int number3 = 150;
		byte number4 = (byte)number3;
		System.out.println(number4);
		
		byte number5 = 50;
		byte number6 = 40;
		int sum = number5 + number6;	
		System.out.println(sum);
		
		char c1 = 'A';	//아스키코드에서 65번
		int sum1 = c1 + 1;
		System.out.println(sum1);
		
		int d1 = 65;
		System.out.println((char)d1);
		
		char e1= 'a';	//아스키코드에서 97번
		int sum2 = e1 + 1;
		System.out.println(sum2);
	
	}

}
