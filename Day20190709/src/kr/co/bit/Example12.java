package kr.co.bit;

public class Example12 {
	public static void main(String[] args) {
		Calculator2 calc = new Calculator2();
		
		User1 user1 = new User1();
		user1.setCalc(calc);
		user1.start();
	
		
		User2 user2 = new User2();
		user2.setCalc(calc);
		user2.start();
	
	}
}
