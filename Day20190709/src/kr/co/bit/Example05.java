package kr.co.bit;

import java.util.function.IntPredicate;

public class Example05 {
	public static void main(String[] args) {
		//2배수 검사
		IntPredicate pa = a -> a%2 == 0;
		//3배수 검사
		IntPredicate pb = b -> b%3 == 0;
		//5배수 검사
		IntPredicate pc = c -> c%5 == 0;
		
		IntPredicate pab;
		IntPredicate pabc;
		
		
		pab = pa.and(pb);	//2배수이면서 3배수인거. 
		System.out.println("2와 3의 배수입니까? " + pab.test(9));

		pabc = pa.and(pb.and(pc));	//2배수이면서 3배수이면서 5배수인값
		System.out.println("2와 3과 5의 배수입니까? " + pabc.test(60));
		
		pab = pa.or(pb);	//2배수이거나 3배수인거. 
		System.out.println("2 또는 3의 배수입니까? " + pab.test(9));
	
		pab = pa.negate();
		System.out.println("홀수입니까? " + pab.test(9));
		
	}
}
