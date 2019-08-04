package stream;

import java.util.Arrays;
import java.util.List;

public class MapAndReduceExample {
	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(new Student("신용권", 10), new Student("홍길동", 20), new Student("김자바", 30));
		
		double avg = studentList.stream()
				.mapToInt(Student::getScore)	// 학생 객체를 점수로 매핑
				.average().getAsDouble();		// 최종 처리(평균 점수)
		
		System.out.println("평균 점수 : " + avg);
	}
}
