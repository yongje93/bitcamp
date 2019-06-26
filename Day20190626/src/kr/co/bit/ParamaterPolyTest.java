package kr.co.bit;

class PersonInfo {
	public void showSleepingType(Person person) {
		person.showSleepStyle();
	}
}

public class ParamaterPolyTest {
	
	public static void main(String[] args) {
		PersonInfo pf = new PersonInfo();
		Person person = new Person();
		Employee employee = new Employee();
		Student student = new Student();
		President president = new President();
		
		pf.showSleepingType(person);
		pf.showSleepingType(employee);
		pf.showSleepingType(student);
		pf.showSleepingType(president);
		
	}
	
}
