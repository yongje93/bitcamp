package kr.co.bit;

public class House {
	public int price;
	public String dong;
	public int size;
	public String kind;
	
	public House() {
		this(100, 32, "동판교", "아파트");
		
	}
	public House(int price) {
		this(price, 32, "동판교", "아파트"); 
	}
	
	public House(int price, int size) {
		this(price, size, "동판교", "아파트"); 
	}
	
	public House(int price, int size, String dong) {
		this(price, size, dong, "아파트"); 
	}
	
	public House(int price, int size, String dong, String kind) {
		this.price = price;
		this.size = size;
		this.dong = dong;
		this.kind = kind;
	}
	
	public static void main(String[] args) {
		House house1 = new House();
		House house2 = new House(300);
		House house3 = new House(300, 400);
		House house4 = new House(300, 400, "서초동");
		House house5 = new House(300, 400, "서초동", "빌라");
		
		System.out.println(house1.price + " " + house1.size + " " + house1.dong + " " + house1.kind);
		System.out.println(house2.price + " " + house2.size + " " + house2.dong + " " + house2.kind);
		System.out.println(house3.price + " " + house3.size + " " + house3.dong + " " + house3.kind);
		System.out.println(house4.price + " " + house4.size + " " + house4.dong + " " + house4.kind);
		System.out.println(house5.price + " " + house5.size + " " + house5.dong + " " + house5.kind);
		
	}
	
}
