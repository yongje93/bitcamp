package kr.co.bit;

public class Boiler {
	private String maker;
	public int temp;
	private String color;
	
	public void set() {
		maker = "�ͶѶ��";
		System.out.println(maker);
	}
	
	public void tempUp() {	// 1���� �ø��� �Լ�
		temp++;
	}
	public void tempUp(int amount) { 
		temp = temp+ amount;
	}
	
	public static void main(String[] args) {
		Boiler boiler = new Boiler();
		boiler.tempUp();
		System.out.println(boiler.temp);
		boiler.tempUp(10);
		System.out.println(boiler.temp);
	}
}
