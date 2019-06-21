package kr.co.bit;

public class First5 {
	public static void main(String[] args) {
		char logic1 = 'A';
		String str = (logic1 == 'A'||logic1 == 'a')?"대문자와 소문자는 같다.":"대문자와 소문자가 다르다.";
		System.out.println(str);
		
		System.out.println("주문선택 y/n");
		char ju = 'n';
		String str1 = (ju == 'y'||ju == 'Y')?"주문선택":"주문취소";
		System.out.println(str1);
	}
}
