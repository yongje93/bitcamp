package kr.co.bit;

interface Interface1 {
	public static final int interVar = 10;

	public abstract void interface1Method();
}

class Interface1Impl extends Object implements Interface1 {

	@Override
	public void interface1Method() {
		System.out.println("interface1Method ±¸Çö");
	}

}

public class InterfaceTest1 {
	public static void main(String[] args) {
		Interface1Impl in1Impl = new Interface1Impl();
		System.out.println("in1Impl.interVar = " + in1Impl.interVar);
		System.out.println("Interface1.interVar = " + Interface1.interVar);
		in1Impl.interface1Method();
		
		Interface1 it1 = new Interface1Impl();
		it1.interface1Method();
		
	}
}
