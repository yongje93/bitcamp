package kr.co.bit;

import java.util.function.IntSupplier;

public class Example07 {
	public static void main(String[] args) {
		// return 하고자하는 타입을 명시해준다.
		IntSupplier is1 = () -> (int)(Math.random()*6)+1;
		
		System.out.println("눈의 수 : " + is1.getAsInt());
	}
}
