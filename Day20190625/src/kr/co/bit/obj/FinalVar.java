package kr.co.bit.obj;

class VarClass {
	final int x;	//���ڻ��
	static final int y;
	final double PI;
	static {
		y = 100;	//ó������ ������.
	}

	public VarClass(int x) {
		this.x = x;
		PI = 3.14;
	}
}

public class FinalVar {
	public static void main(String[] args) {
//		VarClass.y = 30;
		VarClass vc1 = new VarClass(10);
//		vc1.y = 50;
//		vc1.x = 40;		
		VarClass vc2 = new VarClass(20);
	}
}
