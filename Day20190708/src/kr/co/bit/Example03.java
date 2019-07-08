package kr.co.bit;

public class Example03 {
	public static <T> Box<T> boxing(T t) {	//메서드에서 제네릭을 선언할 때는 반환형 앞에 제네릭을 명시해줘야 한다.
		Box<T> box = new Box<T>();
		box.set(t);
		return box;
	}
	
	public static void main(String[] args) {
		Example03 ex = new Example03();
		//ex.boxing("String"); // 타입을 여기서 정해준다.
		Box<Integer> box1 = Example03.<Integer>boxing(50);
		System.out.println(box1.get());
		Box<String> box2 = boxing("홍길동");
		System.out.println(box2.get());
		
	}
	
}
