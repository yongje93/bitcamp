package kr.co.bit;

public class Employee extends Person { // �ٿ�ĳ���� Ŭ�������� Ŭ�����δ� �ٿ�ĳ���ø� ����.
	private String department;
	int x;

	public Employee() {
		this(null, 0);
	}

	public Employee(String department, int x) {
		this.department = department;
		this.x = x;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public void sleep() {
		System.out.println("�������� �Ϲ������� 7�ð��� �ܴ�.");
	}

	@Override
	public void showSleepStyle() {
		System.out.println("�������� �Ͽ� �Ѱ� ������ �����ϴ�.");
	}

	@Override
	public String toString() {
		return "Employee [department=" + department + "]";
	}

}
