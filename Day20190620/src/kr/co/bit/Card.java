package kr.co.bit;

public class Card {
	String kind; // 무늬
	int number; // 숫자

	public Card() {
		kind = null;
		number = 0;
	}

	public static int width; // 가로길이
	public static int height; // 세로길이
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
		System.out.println(card1.kind+" : " + card1.number +" 가로의 길이 = "+ card1.width +" 세로의 길이 = " + card1.height);
		
		Card card2 = new Card();
		card2.kind = "HEART";
		card2.number = 7;
		System.out.println(card2.kind+" : " + card2.number +" 가로의 길이 = "+ card2.width +" 세로의 길이 = " + card2.height);
		
	}
}	
