package kr.co.bit;

public class User1 extends Thread {
	private Calculator2 calc;

	public void setCalc(Calculator2 calc) {
		this.setName("User1");
		this.calc = calc;
	}

	@Override
	public void run() {
		try {
			calc.setMemory(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
