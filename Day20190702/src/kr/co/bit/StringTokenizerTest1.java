package kr.co.bit;

import java.util.StringTokenizer;

public class StringTokenizerTest1 {

	public static void main(String[] args) {
		String source = "111-111|%������|!��õ��|&��赿";
		StringTokenizer st1 = new StringTokenizer(source, "|%!&");
		
		while(st1.hasMoreTokens()) {
			System.out.println("st1 token : " + st1.nextToken());
		}
		
//		String zip = st1.nextToken();
//		String dou = st1.nextToken();
//		String si = st1.nextToken();
//		String dong = st1.nextToken();
//
//		System.out.println("�����ȣ: " + zip);
//		System.out.println("��: " + dou);
//		System.out.println("��: " + si);
//		System.out.println("��: " + dong);
	}

}
