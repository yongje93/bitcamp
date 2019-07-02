package kr.co.bit;

// 사용자정의 예외
public class ArgsException extends Exception {
	private int argsNumber;

	public ArgsException() {
		super();
	}

	public ArgsException(String msg) {
		super(msg);
	}

	public int getArgsNumber() {
		return argsNumber;
	}

	public void setArgsNumber(int argsNumber) {
		this.argsNumber = argsNumber;
	}

}
