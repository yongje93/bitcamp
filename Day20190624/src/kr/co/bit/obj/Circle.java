package kr.co.bit.obj;

public class Circle {
	public Point point; // �κ�

	public Circle() { // ��ü�� �κ��� ����
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
