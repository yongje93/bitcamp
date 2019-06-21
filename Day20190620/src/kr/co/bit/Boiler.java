package kr.co.bit;

public class Boiler {
	private String maker;
	public int temp;
	private String color;
	
	public void set() {
		maker = "귀뚜라미";
		System.out.println(maker);
	}
	
	public void tempUp() {	// 1도씩 올리는 함수
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
