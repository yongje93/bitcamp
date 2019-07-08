package kr.co.bit;

public class Example05 {
	public static void main(String[] args) {
		RambdaInterface ri;
		
//		ri = new RambdaInterface() {
//			
//			@Override
//			public void method() {
//				System.out.println("method call1");
//			}
//		};
//		ri.method();
		
		// 람다식,,
		ri = () -> System.out.println("method call1");
		ri.method();
		
		RambdaInterface2 ri2;
		ri2 = (x) -> {					// ri2 = x -> System.out.println(x*5); 
			int result = x * 5;
			System.out.println(result);
		};
		ri2.method(5);
		
		RambdaInterface3 ri3;
		ri3 = (x, y) -> {				// ri3 = (x,y) -> x+y;;
			int result = x+y;
			return result;
		};
		System.out.println(ri3.method(2, 5));

		ri3 = (x, y) -> x+y;
		System.out.println(ri3.method(2, 5));
		
		ri3 = (x, y) -> sum(x, y);		// 외부에서 함수 불러도됨.
		System.out.println(ri3.method(2, 5));
		
	}
	
	public static int sum(int x, int y) {
		return x+y;
	}
	
}
