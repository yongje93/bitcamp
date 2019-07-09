package kr.co.bit2;

import java.util.Arrays;

public class Example13 {
	public static void main(String[] args) {
		// 스트림 파이프라인 - 최종처리 (매칭) allMatch(), anyMatch(), noneMatch()
		// predicate 조건을 만족하는지 안하는지 여부 확인.
		int[] intArr = {2,4,6};
		
		boolean result = Arrays.stream(intArr).allMatch(a -> a%2 == 0);
		System.out.println("모두 2의 배수인가? " + result);
		
		result = Arrays.stream(intArr).anyMatch(a -> a%3 == 0);
		System.out.println("하나라도 3의 배수인가? " + result);
		
		result = Arrays.stream(intArr).noneMatch(a -> a%3 == 0);
		System.out.println("3의 배수가 없는가? " + result);
		
		
	}
}
