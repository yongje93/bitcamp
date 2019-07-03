package kr.co.bit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorListIterator {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("축구");
		al.add("야구");
		al.add("레슬링");
		al.add("권투");
		al.add("이종격투기");
		System.out.println("Iterator를 이용한 출력");
		Iterator<String> it = al.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
		System.out.println("ListIterator를 이용한 전방향 출력");
		ListIterator<String> It = al.listIterator();
		while(It.hasNext()) {
			System.out.println(It.next());
		}
		System.out.println();
		System.out.println("ListIterator를 이용한 후방향 출력");
		while(It.hasPrevious()) {
			System.out.println(It.previous());
		}
		
	}
	
}
