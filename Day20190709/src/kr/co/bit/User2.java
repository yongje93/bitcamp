package kr.co.bit;

public class User2 extends Thread {
	private Calculator2 calc;

	public void setCalc(Calculator2 calc) {
		this.setName("User2");
		this.calc = calc;
	}

	@Override
	public void run() {
		try {
			calc.setMemory(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
