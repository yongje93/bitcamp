package kr.co.bit;

public class AutoBoxingTest {

	public static void main(String[] args) {
		int var_int1 = 3;
		Integer intObj1 = new Integer(var_int1);
		
		intObj1 = var_int1;
		System.out.println("intObj1 = " + intObj1);
		
		Integer intObj2 = new Integer("4");
		int var_int2 = intObj2.intValue();
		
		var_int2 = intObj2;
		System.out.println("var_int2 = " + var_int2 );
	}
	
}
