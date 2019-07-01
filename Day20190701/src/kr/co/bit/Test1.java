package kr.co.bit;

public class Test1 {
	private String irum;

	public Test1() {
		irum = "";
	}

	public void method() throws NullPointerException, SpaceException { // Runtime ������ �����Ҷ� ������.
		if (irum == null) {
			throw new NullPointerException();
		}
		if (irum.equals("")) {
			throw new SpaceException("���鿡��");
		}
	}

	public static void main(String[] args) {
		Test1 test1 = new Test1();
		try {
			test1.method();
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} catch (SpaceException e2) {
			e2.printStackTrace();
		}
	}

}
