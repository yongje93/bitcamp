package kr.co.bit;

public class Person {
	private int age;
	private String name;
	private String addr;
	int x;

	public Person() {
		this(0, null, null, 0);
	}

	public Person(int age, String name, String addr, int x) {
		this.age = age;
		this.name = name;
		this.addr = addr;
		this.x = x;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void sleep() {
		System.out.println("����� ���� 10�ð� �ܴ�.");
	}

	public void showSleepStyle() {
		System.out.println("������� ���� ��Ÿ���� �پ��ϴ�.");
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", addr=" + addr + "]";
	}

}
