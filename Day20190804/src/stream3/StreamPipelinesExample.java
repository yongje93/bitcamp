package stream3;

import java.util.Arrays;
import java.util.List;

public class StreamPipelinesExample {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
				new Member("홍길동", Member.MALE, 30), 
				new Member("김나리", Member.FEMALE, 20),
				new Member("신용권", Member.MALE, 40));
		
		double ageAvg = list.stream()					// 스트림
				.filter(m->m.getSex() == Member.MALE)	// 필터
				.mapToInt(Member::getAge)				// 매핑
				.average().getAsDouble();				// 최종처리(평균)
		
		System.out.println("남자 평균 나이 : " + ageAvg);
	}
}
