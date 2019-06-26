package kr.co.bit;

public class Employee extends Person { // 다운캐스팅 클래스에서 클래스로는 다운캐스팅만 있음.
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
		System.out.println("직장인은 일반적으로 7시간을 잔다.");
	}

	@Override
	public void showSleepStyle() {
		System.out.println("직장인은 일에 쫓겨 수면이 부족하다.");
	}

	@Override
	public String toString() {
		return "Employee [department=" + department + "]";
	}

}
