package stream5;

import java.util.Arrays;

// peek는 중간처리 메소드이다.
public class LoopingExample {
	public static void main(String[] args) {
		int[] intArr = {1,2,3,4,5};
		
		System.out.println("peek()를 마지막에 호출한 경우");
		Arrays.stream(intArr)
			.filter(a -> a%2==0)
			.peek(n->System.out.println(n));	// peek는 중간처리 메소드라 마지막에 호출할 경우 동작하지 않는다.
		
		System.out.println("최종 처리 메소드를 마지막에 호출한 경우");
		int total = Arrays.stream(intArr)
				.filter(a -> a%2==0)
				.peek(n->System.out.println(n))
				.sum();
		System.out.println("총합 : " + total);
		
		System.out.println("forEach()를 마지막에 호출한경우");
		Arrays.stream(intArr)
			.filter(a -> a%2==0)
			.forEach(n->System.out.println(n));
	}
}
