package kr.co.bit2;

import java.util.Arrays;
import java.util.List;

public class Example05 {
	public static void main(String[] args) {
		List<Student> slist = Arrays.asList(
					new Student("홍길동", 40),
					new Student("김삿갓", 20),
					new Student("황진이", 10)
				);
		double avg = slist.stream().mapToInt(Student :: getScore).average().getAsDouble();
		
		System.out.println("평균점수 : " + avg);
	}
}
