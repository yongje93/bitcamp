package kr.co.bit;

public class JazzangProcess {
	public Jazzang[] jazzang;

	public JazzangProcess() {
		jazzang = new Jazzang[3];
		jazzang[0] = new Jazzang("짜장면", 5000, 3, 15000);
		jazzang[1] = new Jazzang("짬뽕", 5000, 2, 10000);
		jazzang[2] = new Jazzang("탕수육", 10000, 1, 10000);
	}

	public boolean sangpumProcess(String sangpumName) { // 5
		boolean searchResult = false;
		for (int i = 0; i < jazzang.length; i++) {
			if (jazzang[i].getSangpumName().equals(sangpumName)) {
				sangpumDisp(jazzang[i]);
				searchResult = true;
			}
		}
		return searchResult;
	}

	public void sangpumDisp(Jazzang jazzang) {
		System.out.println("상품이름: " + jazzang.getSangpumName());
		System.out.println("상품단가: " + jazzang.getSangpumDan());
		System.out.println("상품수량: " + jazzang.getSangpumSu());
		System.out.println("판매금액: " + jazzang.getSangpumMoney());

	}
}
