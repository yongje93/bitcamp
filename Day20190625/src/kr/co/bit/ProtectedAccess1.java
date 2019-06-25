package kr.co.bit;

public class ProtectedAccess1 {

	public static void main(String[] args) {
		ProtectedVar pd = new ProtectedVar();
		pd.protectedVar = 100;
		System.out.println(pd.protectedVar);
	}
	
}
