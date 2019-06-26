package kr.co.bit;

public class President extends Person {
	private int salary;
	private String nation;

	public President() {
		this(0, null);
	}

	public President(int salary, String nation) {
		this.salary = salary;
		this.nation = nation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@Override
	public void showSleepStyle() {
		System.out.println("������� �׻� ���� �ð��� �����ϴ�.");
	}

	@Override
	public String toString() {
		return "President [salary=" + salary + ", nation=" + nation + "]";
	}

}
