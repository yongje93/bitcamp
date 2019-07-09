package kr.co.bit;

import java.util.function.IntBinaryOperator;

public class Example07 {
	public static void main(String[] args) {
		IntBinaryOperator operator;

		// 정적 메소드 참조
		operator = (x, y) -> Calculator.staticMethod(x, y);
		System.out.println("결과 1 : " + operator.applyAsInt(1, 2));
		
		operator = Calculator :: staticMethod;
		System.out.println("결과 2 : " + operator.applyAsInt(3, 4));
		
		// 인스턴스 메소드 참조
		Calculator obj = new Calculator();
		operator = (x, y) -> obj.instanceMethod(x, y);
		System.out.println("결과 3 : " + operator.applyAsInt(5, 7));
		
		operator = obj :: instanceMethod;
		System.out.println("결과 4 : " + operator.applyAsInt(6, 10));
		
		
	}
}
