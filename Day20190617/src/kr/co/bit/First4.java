package kr.co.bit;

public class First4 {
	public static void main(String[] args) {
		int logic1 = 5;
		int logic2 = 10;
		// 삼항연산자 (조건식) ? 참 : 거짓
		String str = (logic1 > 0 && logic2 < 9)?"0부터 9사이의 범위이다.":"0부터 9사이의 범위가 아니다.";
		System.out.println(str);
	}
}
