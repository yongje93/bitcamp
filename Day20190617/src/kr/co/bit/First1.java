package kr.co.bit;

public class First1 {
	public static void main(String[] args) {
		//byte 1바이트(8비트) 정수형 (-128~127의 정수)
		byte number1 = 127;
		System.out.println(number1);
		//short 2바이트(16비트) 정수형 (-32768~32767의 정수)
		short number2 = 32767;
		System.out.println(number2);
		//int 4바이트(32비트) 정수형 
		int number3 = 30000;
		System.out.println(number3);
		//long 8바이트(64비트) 정수형
		long number4 = 400000;
		System.out.println(number4);
		//char 문자형
		char alpa = 'A';
		System.out.println(alpa);
		//string 문자열
		String str = "안녕하세요";
		System.out.println(str);
		//float 4바이트 실수형
		float sil = 1.5f;	
		System.out.println(sil);
		//자바는 소수점을 8바이트(double)의 공간으로 만들기 때문에 float일 때는 끝에 f를 붙여줘야한다.
		//double 8바이트 실수형
		double sil1 = 1.5;
		System.out.println(sil1);
		//boolean 논리형 1바이트(참,거짓)
		boolean logic = true;
		System.out.println(logic);
		logic = false;
		System.out.println(logic);
	}
}
