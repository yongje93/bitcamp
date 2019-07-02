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
		return "�̸�: " + name +" ��ȣ: " + number;
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
		Student5 st1 = new Student5("�ſ���", 1);
		Student5 st2 = new Student5("�ſ���", 1);
		System.out.println("==���� ��");
		System.out.println("st1==st2: " + (st1 == st2));
		System.out.println("equals�� ��");
		System.out.println("st1.equals(st2): " + st1.equals(st2));
		System.out.println("st1 = "+st1.toString());
		System.out.println("st2 = "+st2.toString());
	}

}
