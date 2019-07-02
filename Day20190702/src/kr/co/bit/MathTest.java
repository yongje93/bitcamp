package kr.co.bit;

public class MathTest {
	public static void main(String[] args) {
		System.out.println("1부터 100까지의 난수 발생");
		int num = (int)(Math.random()*100)+1;
		System.out.println("1부터 100사이의 숫자: " +num);
		System.out.println("1부터 50까지의 난수 발생");
		num = (int)(Math.random()*50)+1;
		System.out.println("1부터 50사이의 숫자: " +num);
		System.out.println("1부터 20까지의 난수 발생");
		num = (int)(Math.random()*20)+1;
		System.out.println("1부터 20사이의 숫자: " +num);
		
	}
}
