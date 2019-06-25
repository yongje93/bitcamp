package kr.co.bit.obj;

public class Son extends Father {
	protected double gudu;	
	
	public Son() {
		System.out.println(super.gudu);	//변수의 다형성.
		gudu = 140.5;
	}
	
	public static void main(String[] args) {
		Son son = new Son();
		System.out.println(son.gudu);
	}
}
