package day20190626;

public class InterfaceTest implements Parent {

	@Override
	public void run() { // 추상메소드 구현
		System.out.println("추상메소드 구현");
	}

	public void setState(boolean state) {
		System.out.println("인터페이스의 디폴트 메소드 재정의");
	}

	public static void main(String[] args) {
		
		boolean state = true;
		
		Parent parent = new Parent() {
			public void run() {
				System.out.println("익명객체 구현");
			}
		};
		
		parent.run();	// 익명 객체 구현
		
		Parent.change();	// 정적 메소드 구현
		
		InterfaceTest test = new InterfaceTest();
		test.setState(state);	// 디폴트 메소드 재정의
	
	}

}
