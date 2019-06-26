package kr.co.bit;

public class PersonMain {

	public static void main(String[] args) {
		Person person1 = new Student();
		Person person2 = new Employee();
		Person person3 = new President();

		Person person4 = new Person();
		Student student = (Student) person4; // 부모에서 자식으로.

	}

}
