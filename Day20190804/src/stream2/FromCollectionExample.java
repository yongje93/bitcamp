package stream2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// 컬렉션으로부터 스트림 얻기
public class FromCollectionExample {
	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(new Student("신용권", 10), new Student("홍길동", 20), new Student("김자바", 30));
		
		Stream<Student> stream = studentList.stream();
		stream.forEach(s -> System.out.println(s.getName()));
	}
}
