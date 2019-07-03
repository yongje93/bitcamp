package kr.co.bit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorListIterator {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("�౸");
		al.add("�߱�");
		al.add("������");
		al.add("����");
		al.add("����������");
		System.out.println("Iterator�� �̿��� ���");
		Iterator<String> it = al.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
		System.out.println("ListIterator�� �̿��� ������ ���");
		ListIterator<String> It = al.listIterator();
		while(It.hasNext()) {
			System.out.println(It.next());
		}
		System.out.println();
		System.out.println("ListIterator�� �̿��� �Ĺ��� ���");
		while(It.hasPrevious()) {
			System.out.println(It.previous());
		}
		
	}
	
}
