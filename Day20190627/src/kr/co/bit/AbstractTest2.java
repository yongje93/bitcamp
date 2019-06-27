package kr.co.bit;

abstract class AbClass1 {
	abstract void abMethod1();
}

abstract class AbClass2 extends AbClass1 {
	abstract void abMethod2();
}

class GeneralClass extends AbClass2	{

	@Override
	void abMethod2() {
		System.out.println("abMethod2 �޼ҵ� ����");		
	}

	@Override
	void abMethod1() {
		System.out.println("abMethod1 �޼ҵ� ����");		
	}
	
}

public class AbstractTest2 {
	
	public static void main(String[] args) {
		GeneralClass gc = new GeneralClass();
		gc.abMethod1();
		gc.abMethod2();
	}
	
}
