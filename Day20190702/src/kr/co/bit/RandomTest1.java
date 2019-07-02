package kr.co.bit;

import java.util.Random;

public class RandomTest1 {

	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("1부터 100까지의 난수: " + random.nextInt(101));
		System.out.println("1부터 50까지의 난수: " + random.nextInt(51));
		System.out.println("1부터 20까지의 난수: " + random.nextInt(21));
		System.out.println("int형 전체범위의 난수: " + random.nextInt());
		System.out.println("float형 전체범위의 난수: " + random.nextFloat());
		System.out.println("double형 전체범위의 난수: " + random.nextDouble());
		System.out.println("long형 전체범위의 난수: " + random.nextLong());
		System.out.println("boolean형 전체범위의 난수: " + random.nextBoolean());
	}

}
