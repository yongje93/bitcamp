package kr.co.bit;

public class Switch_Test2 {
	
	public static void main(String[] args) {
		String operator = "%";
		switch(operator) {
			case "+":
				System.out.println(5+5);
				break;
			case "-":
				System.out.println(5-2);
				break;
			case "X": case "x":
				System.out.println(5*5);
				break;
			case "/":
				System.out.println(5/2);
				break;
			case "%":
				System.out.println(5%2);
				break;
			default:
				System.out.println("연산자가 없습니다.");
		}
	}
}
