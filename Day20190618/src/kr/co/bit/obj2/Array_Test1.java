package kr.co.bit.obj2;

import java.util.ArrayList;

public class Array_Test1 {

	public static void main(String[] args) {
		String[] ar = new String[3];
		ar[0]="안녕하세요";
		ar[1]="감사합니다";
		ar[2]="학원입니다";
		
		for(int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
		
		int[] number;
		number = new int[3]; 
		number[0] = 10;
		number[1] = 20;
		number[2] = 30;
		for (int i = 0; i < number.length; i++) {
			System.out.println(number[i]);
//			System.out.println(number[1]);
//			System.out.println(number[2]);
		}
	
		ArrayList<Integer> list = new ArrayList();	// 고정타입 외에 다른 타입은 못들어온다.
		//list.add("문자열");
		list.add(1);
		//list.add(1.5);
		
//		ArrayList<Integer> numberList = new ArrayList<Integer>();
//		numberList.add(10);
//		numberList.add(20);
//		numberList.add(30);
//		for (int i = 0; i < numberList.size(); i++) {
//			System.out.println(numberList.get(i));
//		}
//		 	System.out.println(numberList.get(1));
//		 	System.out.println(numberList.get(2));

	}

}