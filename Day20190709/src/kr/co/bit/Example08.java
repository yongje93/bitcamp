package kr.co.bit;

import java.util.function.ToIntBiFunction;

public class Example08 {
	public static void main(String[] args) {
		ToIntBiFunction<String, String> func;
		
		func = (a, b) -> a.compareToIgnoreCase(b);
		print(func.applyAsInt("java8", "JAVA8"));
		
		func = String :: compareToIgnoreCase;		//매개변수의 타입을 기준으로
		print(func.applyAsInt("java8", "JAVA8"));
		
	}
	
	public static void print(int order) {
		if(order < 0) {
			System.out.println("사전순으로 먼저 옵니다.");
		} else if(order == 0) {
			System.out.println("동일한 문자열입니다.");
		} else {
			System.out.println("사전순으로 나중에 옵니다.");
		}
	}
}
