package kr.co.bit.obj3;

public class AirCon {
	// static이 있으면 new 연산자가 없어도 바로 이용이 가능하다.
	
	// 공간을 만들어줌
	String company;
	String color;
	int price;
	int size;
	int temp;

	/*
	 * public AirCon() { // 생성자 함수 constructor // 0으로 초기화 해줌.
	 * 		company= null; 
	 * 		color = null; 
	 * 		price = 0; 
	 * 		size = 0; 
	 * 		temp = 0; 
	 * }
	 */

	public void powerOn() {
		System.out.println("전원을 켰다.");
	}

	public void powerOff() {
		System.out.println("전원을 껐다.");
	}

	public void tempUp() {
		temp++;
	}

	public void tempDown() {
		temp--;
	}
}
