package kr.co.bit;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class Example09 {
	private static List<Student> list = Arrays.asList(
			new Student("홍길동", 80, 92),
			new Student("김삿갓", 90, 80)
			);
	
	public static int avg(ToIntFunction<Student> func) {
		int sum = 0;
		for (Student student : list) {
			sum += func.applyAsInt(student);
		}
		return sum/list.size();
	}
	
	public static void main(String[] args) {
		System.out.println("영어 평균 점수 : " + avg(t -> t.getEng()));
		System.out.println("수학 평균 점수 : " + avg(t -> t.getMath()));
	}
}
