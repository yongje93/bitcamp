package kr.co.bit.obj2;

import java.util.ArrayList;

public class Array_Test1 {

	public static void main(String[] args) {
		String[] ar = new String[3];
		ar[0]="�ȳ��ϼ���";
		ar[1]="�����մϴ�";
		ar[2]="�п��Դϴ�";
		
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
	
		ArrayList<Integer> list = new ArrayList();	// ����Ÿ�� �ܿ� �ٸ� Ÿ���� �����´�.
		//list.add("���ڿ�");
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