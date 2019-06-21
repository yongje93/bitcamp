package kr.co.bit;

public class Test {
	public void printInfo(String ...arg) {	//가변인수
		if (arg.length != 0) {
			for (int i = 0; i < arg.length; i++) {
				System.out.println(arg[i]);
			}
		}
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.printInfo();
		test.printInfo("가가가");
		test.printInfo("나나나", "다다다");
	}

}
