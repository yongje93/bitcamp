package kr.co.bit2;

import java.util.Arrays;

public class Example12 {
	public static void main(String[] args) {
		// forEach 와 같은 반복 처리문. peek()
		// peek() -> 중간처리 단계에 있어야 한다. 마지막에 있으면 안됨.
		// forEach 뒤에는 연산 할 수 있는 애들이 못옴.
		// peek 뒤에는 연산할 수 있는 애들이 올 수 있다.
		int[] intArr = {1,2,3,4,5};
		
		System.out.println("foreach 출력");
		Arrays.stream(intArr).filter(a -> a%2 == 0)
			.forEach(n -> System.out.print(n + ","));
		System.out.println();
		
		System.out.println("peek 잘못 사용법.");
		int total = Arrays.stream(intArr).filter(a -> a%2 == 0).peek(n -> System.out.print(n + ",")).sum();
		System.out.println(" 총합 : " + total);
		
	}
}
