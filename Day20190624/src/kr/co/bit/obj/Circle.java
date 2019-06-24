package kr.co.bit.obj;

public class Circle {
	public Point point; // 부분

	public Circle() { // 전체가 부분을 가짐
		point = new Point();
	}

	public static void main(String[] args) {
		Circle circle = new Circle();
		
		circle.point.x = 10;
		circle.point.y = 20;
		
		System.out.println(circle.point.x);
		System.out.println(circle.point.y);
	}
}
