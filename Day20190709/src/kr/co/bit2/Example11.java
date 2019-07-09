package kr.co.bit2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Example11 {
	public static void main(String[] args) {
		// 스트림 파이프라인 - 중간처리 (정렬) sorted
		IntStream intStream = Arrays.stream(new int[] {5,3,1,4,2});
		intStream.sorted().forEach(n -> System.out.print(n + ","));
		System.out.println();
		
		// 객체 요소일 경우
		List<Student> stdList = Arrays.asList(
					new Student("홍길동", 30),
					new Student("김삿갓", 20),
					new Student("황진이", 10),
					new Student("유관순", 25)
				);
		stdList.stream().sorted()
			.forEach(s -> System.out.print(s.getScore() + ","));	// default는 오름차순.
		System.out.println();
		
		stdList.stream().sorted(Comparator.reverseOrder())			// 내림차순 sorted(Comparator.reverseOrder())
			.forEach(s -> System.out.print(s.getScore() + ","));	
	}
}
