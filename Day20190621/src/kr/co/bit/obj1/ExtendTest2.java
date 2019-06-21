package kr.co.bit.obj1;

class Super extends Object {
	protected int x;

	public Super() {
		x = 90;
	}

	public void superMethod() {
		System.out.println("super method");
	}
}

class Sub extends Super {
	protected int y;

	public Sub() {
		y = 10;
	}

	public void subMethod() {
		System.out.println("sub method");
	}
}

class SubSub extends Sub {
	protected int z;

	public SubSub() {
		z = 20;
	}

	public void subSubMethod() {
		System.out.println("subsub method");
	}
}

public class ExtendTest2 {

	public static void main(String[] args) {
		SubSub ss = new SubSub();
		System.out.println("ss.x = " + ss.x);
		System.out.println("ss.y = " + ss.y);
		System.out.println("ss.z = " + ss.z);
		ss.superMethod();
		ss.subMethod();
		ss.subSubMethod();
	}

}
