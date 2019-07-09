package kr.co.bit2;

import java.util.Arrays;
import java.util.List;

public class Example07 {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
					new Member("홍길동", Member.MALE, 30), 
					new Member("유관순", Member.FEMALE, 20),
					new Member("김삿갓", Member.MALE, 34), 
					new Member("황진이", Member.FEMALE, 50)
				);
		// 스트림 파이프라인 - 중간 처리 (필터링) filter() - 조건 필터링 / distinct() - 중복제거
		double ageAvg = list.stream()								
				.filter(m -> m.getGender() == Member.MALE)
				.mapToInt(Member :: getAge)
				.average()
				.getAsDouble();
		System.out.println("남자 평균 나이 : " + ageAvg);
	}
}
