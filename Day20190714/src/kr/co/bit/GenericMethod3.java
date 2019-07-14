package kr.co.bit;

class Util3 {
	public static <T extends Number> int compare(T t1, T t2) {
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		return Double.compare(v1, v2);
	}
}

public class GenericMethod3 {
	public static void main(String[] args) {
		//String str = Util.compare("A", "B");
		int result1 = Util3.compare(10, 20);
		System.out.println(result1);		// 실행결과 -1 (앞에 숫자가 더 작으므로 -1)
		
		int result2 = Util3.compare(4.5, 3);
		System.out.println(result2);		// 실행결과 1 	(앞에 숫자가 더 크므로 +1)
	}
}
