package kr.co.bit;

public class Sawon {
	protected String name;
	protected String dept;
	protected int salary;

	public Sawon() {
		this("no", "no", 0);
	}

	public Sawon(String name, String dept, int salary) {
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Sawon [이름=" + name + ", 부서=" + dept + ", 연봉=" + salary + "]";
	}

}
