package kr.co.bit;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Example02 {
	private static List<Student> list = Arrays.asList(
					new Student("홍길동", "남자", 90),
					new Student("유관순", "여자", 85),
					new Student("김삿갓", "남자", 70),
					new Student("황진이", "여자", 93)
			);
	
	public static double avg(Predicate<Student> predicate) {
		int count = 0, sum = 0;
		for (Student student : list) {
			if(predicate.test(student)) {
				count++;
				sum += student.getScroe();
			}
		}
		return (double) sum / count;
	}
	
	
	
	public static void main(String[] args) {
		double maleAvg = avg( t -> t.getGender().equals("남자"));
		System.out.println("남자 평균 점수 :" + maleAvg);
		double femaleAvg = avg( t -> t.getGender().equals("여자"));
		System.out.println("여자 평균 점수 :" + femaleAvg);
	}
}
