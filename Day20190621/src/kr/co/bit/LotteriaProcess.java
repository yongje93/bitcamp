package kr.co.bit;

public class LotteriaProcess {

	public Lotteria[] lotteria;

	public LotteriaProcess() {
		lotteria = new Lotteria[5];
		lotteria[0] = new Lotteria("햄버거", 5000, 2, 10000);
		lotteria[1] = new Lotteria("감자튀김", 3000, 1, 3000);
		lotteria[2] = new Lotteria("콜라", 1000, 2, 2000);
		lotteria[3] = new Lotteria("아이스크림", 2000, 2, 4000);
		lotteria[4] = new Lotteria("애플파이", 1000, 3, 3000);

	}

	public boolean sangpumProcess(String sangpumName) {
		boolean searchResult = false;
		for (int i = 0; i < lotteria.length; i++) {
			if (lotteria[i].getSangpumName().equals(sangpumName)) {
				sangpumDisp(lotteria[i]);
				searchResult = true;
			}
		}
		return searchResult;
	}

	private void sangpumDisp(Lotteria lotteria) {
		System.out.println("상품이름: " + lotteria.getSangpumName());
		System.out.println("상품단가: " + lotteria.getSangpumDan());
		System.out.println("상품수량: " + lotteria.getSangpumSu());
		System.out.println("판매금액: " + lotteria.getSangpumMoney());

	}

}
