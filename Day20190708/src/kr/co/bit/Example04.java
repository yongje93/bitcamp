package kr.co.bit;

public class Example04 {
	// 인스턴스 클래스
	class InnerClass1 { // 생성자, 필드, 일반메소드 선언 가능, 스태틱은 선언 안됨.
		int field1;
		public InnerClass1() {}
		void method01() {}
		// static int field2; //에러
		// static void method02() {} //에러
	}

	// 스태틱 클래스
	static class InnerClass2 { // 생성자, 필드, 일반메소드, 스태틱 선언 가능 
		int field1;
		public InnerClass2() {}
		void method01() {}
		static int field2;
		static void method02() {}
	}

	public void method1() {
		// 지역 클래스(로컬 클래스)
		class InnerClass3 {
			int field1;
			public InnerClass3() {}
			void method01() {}
			//static int field2; // 에러
			//static void method02() {} // 에러
		}
		InnerClass3 ic = new InnerClass3();
		
	}
	
	public void method2() {
		//InnerClass3 ic = new InnerClass3();	//영역자체가 메서드1에 묶여있다.
	}

	public static void main(String[] args) {
		Example04 ex = new Example04(); 
		new Example04();	// 한번만 사용할때.
		
		Interface1 inter1 = new Interface1() {	// 익명객체를 선언하고 인터페이스의 기능을 모두 직접적으로 구현. 익명 클래스 (자바 1.8버전 표준)
			
			@Override
			public void method2() {
				
			}
			
			@Override
			public void method1() {
				
			}
		};
		
	}

}
