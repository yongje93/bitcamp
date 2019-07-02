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
		if (obj instanceof Student3) {	//�ٿ�ĳ���� ��������.
			st = (Student3) obj;		//�θ� �ڽĿ��� �ִ´�.
		}
		return (st != null && st.name.equals(name) && st.number == number);
	}

}

public class EqualTest1 {

	public static void main(String[] args) {
		Student3 st1 = new Student3("�ſ���", 1);
		Student3 st2 = new Student3("�ſ���", 1);
		System.out.println("==���� ��");
		System.out.println("st1==st2: " + (st1 == st2));
		System.out.println("equals�� ��");
		System.out.println("st1.equals(st2): " + st1.equals(st2));
	}

}
