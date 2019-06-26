package kr.co.bit;

public class InstanceOfTest {
	
	public static void main(String[] args) {
		President president1 = new President();
		
		Person person1 = president1;
		
		if(person1 instanceof President) {
			President president2 = (President) person1;
			System.out.println("person1�� President Ÿ������ ĳ���� ����");
		} else {
			System.out.println("person1�� ĳ���� �� �� ����.");
		}
		
		Person person2 = new Person();
		
		if(person2 instanceof President) {
			President president3 = (President) person2;
			System.out.println("person2�� President Ÿ������ ĳ���� ����");
		} else {
			System.out.println("person2�� ĳ���� �� �� ����.");
		}
	}
	
}
