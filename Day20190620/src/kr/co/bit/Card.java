package kr.co.bit;

public class Card {
	String kind; // ����
	int number; // ����

	public Card() {
		kind = null;
		number = 0;
	}

	public static int width; // ���α���
	public static int height; // ���α���
	static {
		width = 100;
		height = 250;
	}
	public void set() {
		int lv = 0;
		System.out.println(lv);
	}
	
	public static void main(String[] args) {
		Card card1 = new Card();
		card1.kind = "SPADE";
		card1.number = 4;
		System.out.println(card1.kind+" : " + card1.number +" ������ ���� = "+ card1.width +" ������ ���� = " + card1.height);
		
		Card card2 = new Card();
		card2.kind = "HEART";
		card2.number = 7;
		System.out.println(card2.kind+" : " + card2.number +" ������ ���� = "+ card2.width +" ������ ���� = " + card2.height);
		
	}
}	
