package kr.co.bit;

import java.util.ArrayList;

public class ArrayListTest {
	
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>();
		array.add("�ѱ�");
		array.add("�̱�");
		array.add("�߱�");
		System.out.println("ArrayList�� ��Ҹ� �߰��ϰ� ���");
//		for(int i = 0; i < array.size(); i++) {
//			System.out.println(array.get(i));
//		}
		for(String e:array) {
			System.out.println(e);
		}
		System.out.println();
		array.remove(0);
		array.remove("�̱�");
		System.out.println("ArrayList���� ��� ������ ���");
		for(int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
	}

}
