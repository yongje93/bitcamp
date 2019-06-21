package kr.co.bit;

public class MyMathTest2 {
	public static void main(String[] args) {
		System.out.println(MyMath2.add(200L, 100L));
		MyMath2 mm = new MyMath2();
		
		mm.a = 200L;
		mm.b = 100L;
		
		System.out.println(mm.add());
	}
}
