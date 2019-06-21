package kr.co.bit;

public class Args {
	//오버로딩.overloading (다형성)
	public void add(int x) {
		System.out.println("덧셈1");
	}

	public void add(String str) {
		System.out.println(str + " 문자열을 받아서 출력.");
	}

	public void add(double sil) {
		System.out.println(sil + " 실수를 받아서 출력.");
	}
	
	
	public static void main(String[] args) {
		Args arg = new Args();
		arg.add(10);	
		arg.add(1.5);
		arg.add("ㅇㅇ");
		
	}
}
