package kr.co.bit;

public class First3 {

	public static void main(String[] args) {
//		int number1 = 10;
//		number1++;	//number1 = number1 + 1
//		System.out.println(number1);
		
		//선증가
		int number1 = 10;	
		int sum = 0;
		sum = number1++;
		System.out.println(sum+":"+number1);
		
		//후증가
		int number2 = 10;
		int sum2 = 0;
		sum2 = ++number2;
		System.out.println(sum2+":"+number2);

	}

}
