package kr.co.bit.obj2;

public class Logout extends MemberShip {
	
	public Logout() {
		
	}
	
	public void logoutProcess() {
		if (MemberShipMain.session == null) {
			System.out.println("로그인하세요.");
			return;
		}
		System.out.println("로그아웃 되었습니다.");
		MemberShipMain.session = null;
	}

	@Override
	public void closeAll() {
		
	}
}
