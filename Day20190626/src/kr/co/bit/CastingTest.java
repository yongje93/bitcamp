package kr.co.bit;

public class CastingTest {

	public static void main(String[] args) {
		President president1 = new President();
		Person person1 = president1;
		president1 = (President) person1;
		president1.setNation("대한민국");
		System.out.println(president1.getNation());
		
//		President president1 = new President();
//		Person person1 = (Person) president1;	//축소
//		
//		President president2 = (President) person1;	//확장 / 부모가 자식에게 들어가려고함.
//    	president2.setNation("대한민국");
//    	System.out.println(president2.getNation());
//    	
//		Person person2 = new Person();
//		President president3 = (President) person2;
//		president3.setNation("영국");
//		System.out.println(president3.getNation());
	}

}
