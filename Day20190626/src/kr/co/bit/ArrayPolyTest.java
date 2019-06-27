package kr.co.bit;

public class ArrayPolyTest {

	public static void main(String[] args) {
		Person[] pArray = new Person[3];
		pArray[0] = new Employee();
		pArray[1] = new Student();
		pArray[2] = new President();
		
		for(int i = 0; i < pArray.length; i++) {
			pArray[i].showSleepStyle();
		}
	}
	
}
