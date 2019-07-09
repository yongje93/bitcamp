package kr.co.bit2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Example10 {
	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3, 4, 5 };
		
		IntStream intStream = Arrays.stream(intArray);
		intStream.asDoubleStream().forEach(d -> System.out.println(d));
		
		// boxed 는 Wrapper 클래스 형태로 가지고 온다.
		intStream = Arrays.stream(intArray);
		intStream.boxed().forEach(	
				d -> System.out.println(d.intValue()));		
	}
}
