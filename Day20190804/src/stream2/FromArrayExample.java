package stream2;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//베열로부터 스트림 얻기
public class FromArrayExample {
	public static void main(String[] args) {
		String[] strArray = { "홍길동", "김자바", "홍길동" };
		Stream<String> strStream = Arrays.stream(strArray);
		strStream.forEach(s -> System.out.print(s + ","));
		System.out.println();

		int[] intArray = { 1, 2, 3, 4, 5 };
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(a -> System.out.print(a + ","));
	}
}
