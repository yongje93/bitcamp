/*
필드 : x, y, sum, sub, mul, div
메소드 : 기본 생성자에서 x, y값을 입력 받는다.
		calc() - 합, 차, 곱, 몫 계산
		getX()
		getY()
		getSum()
		getMul()
		getDiv()
*/
import java.util.Scanner;

class Compute {
	private int x;
	private int y;
	private int sum;
	private int sub;
	private int mul;
	private double div;
	
	public Compute() { }

	public Compute(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void calc() {
		sum = x + y;
		sub = x - y;
		mul = x * y;
		div = (double) x / y;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public int getSum() { return sum; }
	public int getSub() { return sub; }
	public int getMul() { return mul; }
	public double getDiv() { return div; }
	
	@Override
	public String toString() {
		return x+"\t"+y+"\t"+sum+"\t"+sub+"\t"+mul+"\t"+String.format("%.2f", div);
	}
}

class ComputeMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

//		Compute[] ar = new Compute[3];
//		ar[0] = new Compute(250, 360);
//		ar[1] = new Compute(128, 109);	
//		ar[2] = new Compute(357, 456);

		Compute[] ar = {new Compute(250, 360), 
						new Compute(128, 109),
						new Compute(357, 456)};
		
//		Compute[] ar = new Compute[] {new Compute(250, 360), 
//									  new Compute(128, 109),
//								   	  new Compute(357, 456)};

//		for(int i = 0; i < ar.length; i++) {
//			System.out.print("x : ");
//			int x = scan.nextInt();
//			System.out.print("y : ");
//			int y = scan.nextInt();
//			System.out.println();
//			ar[i] = new Compute(x, y);
//		}

		System.out.println("X\tY\tSUM\tSUB\tMUL\tDIV");
		for(Compute com : ar) {
			com.calc();
			System.out.println(com);
		}
	}
}
