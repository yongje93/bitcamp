package kr.co.bit;

class Student3 {
	String name;
	int number;

	public Student3(String name, int number) {
		this.name = name;
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) {
		Student3 st = null;
		if (obj instanceof Student3) {	//다운캐스팅 가능한지.
			st = (Student3) obj;		//부모를 자식에게 넣는다.
		}
		return (st != null && st.name.equals(name) && st.number == number);
	}

}

public class EqualTest1 {

	public static void main(String[] args) {
		Student3 st1 = new Student3("신용제", 1);
		Student3 st2 = new Student3("신용제", 1);
		System.out.println("==으로 비교");
		System.out.println("st1==st2: " + (st1 == st2));
		System.out.println("equals로 비교");
		System.out.println("st1.equals(st2): " + st1.equals(st2));
	}

}
