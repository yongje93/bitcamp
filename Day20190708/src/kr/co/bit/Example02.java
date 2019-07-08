package kr.co.bit;

public class Example02 {
	// 제네릭 타입은 reference 타입의 형태만 지원한다. primitive 타입은 지원 안함.
	public static void main(String[] args) {
		Box<String> box1 = new Box<String>();	// 타입을 정해주는것이 좋다. generic
		box1.set("abcd");
		System.out.println(box1.get());
		
		Box<Integer> box2 = new Box<Integer>();	// 타입을 정해주는것이 좋다. generic
		box2.set(123);
		System.out.println(box2.get());
		
	}
	

}
