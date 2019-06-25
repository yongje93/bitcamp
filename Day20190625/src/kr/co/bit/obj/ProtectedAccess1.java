package kr.co.bit.obj;

import kr.co.bit.ProtectedVar;

class ProtectedAccess2 extends ProtectedVar {
	public ProtectedAccess2() {
		protectedVar = 100; 
	}

}

public class ProtectedAccess1 {

	public static void main(String[] args) {
		ProtectedVar pd = new ProtectedVar();
		// pd.protectedVar = 100;
	}

}
