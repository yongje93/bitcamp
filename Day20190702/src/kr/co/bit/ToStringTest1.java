package kr.co.bit;

class Student5 {
	String name;
	int number;

	public Student5(String name, int number) {
		this.name = name;
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "이름: " + name +" 번호: " + number;
	}
	
	@Override
	public boolean equals(Object obj) { 
		Student5 st = null;
		if (obj instanceof Student5) { 
			st = (Student5) obj;
		}
		return (st != null && st.name.equals(name) && st.number == number);
	}

}

public class ToStringTest1 {

	public static void main(String[] args) {
		Student5 st1 = new Student5("신용제", 1);
		Student5 st2 = new Student5("신용제", 1);
		System.out.println("==으로 비교");
		System.out.println("st1==st2: " + (st1 == st2));
		System.out.println("equals로 비교");
		System.out.println("st1.equals(st2): " + st1.equals(st2));
		System.out.println("st1 = "+st1.toString());
		System.out.println("st2 = "+st2.toString());
	}

}
