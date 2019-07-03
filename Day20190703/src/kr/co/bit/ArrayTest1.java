package kr.co.bit;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayTest1 {

	public static void main(String[] args) {
		ArrayList<String> array1 = new ArrayList<String>();
		array1.add("A");
		
		ArrayList<Integer> array2 = new ArrayList<Integer>();
		array2.add(9);
		array2.add(2);
		array2.add(4);
		array2.add(1);
		System.out.println(array2);
		Collections.sort(array2);
		System.out.println(array2);

//		ArrayList array1 = new ArrayList();
//		array1.add("A");
//		array1.add("B");
//		array1.add("C");
//		array1.add("D");
//		array1.add("E");
//		System.out.println(array1);
//		array1.remove(2);
//		System.out.println(array1);
//		array1.add(2, "C");
//		System.out.println(array1);
//		array1.add(2, "G");
//		System.out.println(array1);
//		Collections.sort(array1);
//		System.out.println(array1);
	}
	
}
