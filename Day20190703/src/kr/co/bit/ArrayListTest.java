package kr.co.bit;

import java.util.ArrayList;

public class ArrayListTest {
	
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>();
		array.add("한국");
		array.add("미국");
		array.add("중국");
		System.out.println("ArrayList에 요소를 추가하고 출력");
//		for(int i = 0; i < array.size(); i++) {
//			System.out.println(array.get(i));
//		}
		for(String e:array) {
			System.out.println(e);
		}
		System.out.println();
		array.remove(0);
		array.remove("미국");
		System.out.println("ArrayList에서 요소 제거후 출력");
		for(int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
	}

}
