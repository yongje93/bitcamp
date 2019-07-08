package kr.co.bit;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Example08 {
	private static List<Student> list = Arrays.asList(
			new Student("홍길동", 80, 92),
			new Student("김삿갓", 90, 80)
			);
	
	public static void printString(Function<Student, String> func) {	//Function 인터페이스 apply()함수만 가지고 있고 기능은 정의가 되어있지 않음.
		for (Student student : list) {
			System.out.print(func.apply(student) + " "); // apply 함수가 뭘할지는 모른다. 일단 apply에서 나오는 결과값을 출력할 것이다.
		}
		System.out.println();
	}
	
	public static void printInt(ToIntFunction<Student> func) {
		for (Student student : list) {
			System.out.print(func.applyAsInt(student) + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("[학생 이름]");
		printString(t -> t.getName()); 	// t는 실질적으로 받고자 하는 것. func.apply(student)가 실행됨. apply의 정의를 여기서 한다. 함수의 기능을 인자처럼 전달.
		System.out.println("[영어 점수]");
		printInt(t -> t.getEng());	// t는 타입이 정해지지 않았지만 student 객체라는 걸 알고있다. 함수적 인터페이스에서 제네릭 타입을 Student라고 정해주었기 때문에 알아서 인식을 한다.
		System.out.println("[수학 점수]");
		printInt(t -> t.getMath());
	}
}
