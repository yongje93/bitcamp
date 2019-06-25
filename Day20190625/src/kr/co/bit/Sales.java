package kr.co.bit;

public class Sales extends Sawon {
	protected int commition;

	public Sales() {
		commition = 0;
	}

	public Sales(String name, String dept, int salary, int commition) {
		super(name, dept, salary);
		this.commition = commition;
	}

	public int getCommition() {
		return commition;
	}

	public void setCommition(int commition) {
		this.commition = commition;
	}

	@Override
	public String toString() {
		return super.toString() + " Sales [����=" + commition + "]";
	}

	public static void main(String[] args) {
		Sales sales = new Sales("ȫ�浿", "���ߺ�", 1000, 1000);
		String str = sales.toString();
		System.out.println(str);
	}
}
