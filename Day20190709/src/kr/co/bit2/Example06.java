package kr.co.bit2;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example06 {
	public static int sum = 0;

	public static void main(String[] args) {
		String[] strArr = { "홍길동", "황진이", "김삿갓" };
		Stream<String> strStream = Arrays.stream(strArr);
		strStream.forEach(a -> System.out.println(a + ","));
		System.out.println();

		int[] intArr = { 1, 2, 3, 4, 5 };
		IntStream intStream = Arrays.stream(intArr);
		intStream.forEach(a -> System.out.println(a + ","));
		System.out.println();

		IntStream intStream1 = IntStream.rangeClosed(1, 100);
		intStream1.forEach(a -> sum += a);
		System.out.println("총합 : " + sum);
	}
}
