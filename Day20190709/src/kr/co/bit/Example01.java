package kr.co.bit;

import java.util.function.IntBinaryOperator;

public class Example01 {
	private static int[] scores = {92, 95, 87, 75, 64};
	
	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for (int i : scores) {
			result = operator.applyAsInt(result, i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		int max = maxOrMin(	(a,b) -> (a>=b)?a:b	);
		System.out.println("최대값: " + max);
		int min = maxOrMin(	(a,b) -> (a<=b)?a:b );
		System.out.println("최소값: " + min);
	
	}
}
