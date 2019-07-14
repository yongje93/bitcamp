package kr.co.bit;

interface MyFunctionalInterface3 {
	public void method();
}

class UsingThis {
	public int outterField = 10;
	
	class Inner {
		int innerField = 20;
		
		void method() {
			MyFunctionalInterface3 fi = () -> {
				System.out.println("outterField: " + outterField);
				System.out.println("outterField: " + UsingThis.this.outterField);
				System.out.println();
				System.out.println("innerField: " + innerField);
				System.out.println("innerField: " + this.innerField);
			};
			fi.method();
		}
	}
}

public class RambdaExample3 {
	
	public static void main(String[] args) {
		UsingThis usingThis = new UsingThis();
		UsingThis.Inner inner = usingThis.new Inner();
		inner.method();
	}
}
