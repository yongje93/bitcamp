package kr.co.bit;

public class Test {
	private String irum;

	public Test() {
		irum = null;
	}

	public static void main(String[] args) {
		Test test = new Test();
		try {
			if(test.irum == null || test.irum.equals("")) {
				System.out.println("---");
			}
		} catch (Exception e) {
			System.out.println("�̸��� ���Դϴ�.");
		}

//		if (test.irum == null) {
//			System.out.println("�̸��� ���Դϴ�.");
//		}

	}

}
