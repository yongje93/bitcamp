package kr.co.bit;

import java.util.Random;

public class RandomTest1 {

	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("1���� 100������ ����: " + random.nextInt(101));
		System.out.println("1���� 50������ ����: " + random.nextInt(51));
		System.out.println("1���� 20������ ����: " + random.nextInt(21));
		System.out.println("int�� ��ü������ ����: " + random.nextInt());
		System.out.println("float�� ��ü������ ����: " + random.nextFloat());
		System.out.println("double�� ��ü������ ����: " + random.nextDouble());
		System.out.println("long�� ��ü������ ����: " + random.nextLong());
		System.out.println("boolean�� ��ü������ ����: " + random.nextBoolean());
	}

}
