package kr.co.bit.obj2;

public class Logout extends MemberShip {
	
	public Logout() {
		
	}
	
	public void logoutProcess() {
		if (MemberShipMain.session == null) {
			System.out.println("�α����ϼ���.");
			return;
		}
		System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
		MemberShipMain.session = null;
	}

	@Override
	public void closeAll() {
		
	}
}
