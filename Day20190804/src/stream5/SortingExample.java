package stream5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class SortingExample {
	public static void main(String[] args) {
		IntStream intStream = Arrays.stream(new int[] {5,3,2,1,4});
		intStream
			.sorted()
			.forEach(n->System.out.print(n+","));
		System.out.println();
		
		List<Student> studentList = Arrays.asList(new Student("홍길동", 10),new Student("신용권", 20),new Student("김자바", 30));
		studentList.stream()
			.sorted()								// 정수를 기준으로 오름차순
			.forEach(s -> System.out.print(s.getScore() + ","));
		System.out.println();
		
		studentList.stream()
			.sorted( Comparator.reverseOrder() )	// 정수를 기준으로 내림차순
			.forEach(s -> System.out.print(s.getScore() + ","));
			System.out.println();
	
		
	}
}
