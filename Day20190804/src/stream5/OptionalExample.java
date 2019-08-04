package stream5;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();	//값이 없는 상태 (NoSuchElementException 예외발생)
		
		// 방법1
		OptionalDouble optional = list.stream()
				.mapToInt(Integer :: intValue)
				.average();
		if(optional.isPresent()) {	// 값이 있는지 없는지 체크
			System.out.println("방법1_평균 : " + optional.getAsDouble());
		} else {
			System.out.println("방법1_평균 : 0.0");
		}
		
		// 방법2
		double avg = list.stream()
				.mapToInt(Integer :: intValue)
				.average()
				.orElse(0.0);
		System.out.println("방법2_평균 : " + avg);
		
		//방법3
		list.stream()
			.mapToInt(Integer :: intValue)
			.average()
			.ifPresent(a->System.out.println("방법3_평균 : " +a));
	}
}
