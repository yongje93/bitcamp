class Test{
	int a,b;
}

public class TestMain {
	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2 = t1;
		t1.a = 2;
		t1.b = 5;
		System.out.print( t1.a * t1.b+ "\t" + t2.a*t2.b );
		System.out.println();
	
		t2.a = 7;
		t2.b = 5;
		System.out.print( t1.a * t1.b+ "\t" + t2.a*t2.b );
		System.out.println();
		
		t2 = new Test();
		t2.a=5;
		t2.b=5;
		System.out.print( t1.a * t1.b+ "\t" + t2.a*t2.b );
		System.out.println();
		
		int x = (int)(Math.random()*100)+1;
	}
}
