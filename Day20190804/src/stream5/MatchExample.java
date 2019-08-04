package stream5;

import java.util.Arrays;

public class MatchExample {
	public static void main(String[] args) {
		int[] intArr = {2, 4, 6};
		
		boolean result = Arrays.stream(intArr)
				.allMatch(a->a%2==0);		// 모든 요소들이 조건이 맞는지
		System.out.println("모두 2의 배수인가? " + result);
		
		result = Arrays.stream(intArr)
				.anyMatch(a->a%3==0);		// 최소한 한 개의 요소가 조건에 맞는지 
		System.out.println("하나라도 3의 배수가 있는가? " + result);
	
		result = Arrays.stream(intArr)
				.noneMatch(a->a%3==0);		// 모든 요소들이 조건에 안맞는지
		System.out.println("3의 배수가 없는가? " + result);
	}
}
