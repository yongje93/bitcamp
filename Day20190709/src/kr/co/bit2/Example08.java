package kr.co.bit2;

import java.util.Arrays;
import java.util.List;

public class Example08 {
	public static void main(String[] args) {
		// 스트림 파이프라인 - 중간 처리 (필터링) filter() - 조건 필터링 / distinct() - 중복제거
		List<String> names = Arrays.asList(
				"홍길동","김삿갓","유관순","황진이","신사임당", "홍길동");
		names.stream().distinct().forEach(e -> System.out.println(e));
		System.out.println();
		
		names.stream().filter(e -> e.startsWith("유"))
			.forEach(e -> System.out.println(e));
		System.out.println();
		
		names.stream().filter(e -> e.endsWith("동")).distinct()
			.forEach(e -> System.out.println(e));
		System.out.println();
		
	}
}
