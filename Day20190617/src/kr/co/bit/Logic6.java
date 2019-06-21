package kr.co.bit;

public class Logic6 {
	public static void main(String[] args) {
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		
		String operation = args[2];
		int result = 0;
		
		if(operation.equals("+")) {
			result = num1 + num2;
		} else if(operation.equals("-")) {
			result = num1 - num2;
		} else if(operation.equals("x") || operation.equals("X")) {
			result = num1 * num2;
		} else if(operation.equals("/")) {
			result = num1 / num2;
		}
		if(result != 0) {
			System.out.println(num1 + operation + num2 + "=" + result);
		} else {
			System.out.println("연산자가 잘못되었습니다.");
		}
		
	}
}
