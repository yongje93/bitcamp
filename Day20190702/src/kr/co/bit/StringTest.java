package kr.co.bit;

public class StringTest {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Java");
		StringBuffer sb2 = sb.append("Fighting");
		System.out.println("sb == sb2: " +(sb==sb2));
	}
}
