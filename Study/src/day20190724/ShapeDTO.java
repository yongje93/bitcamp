package day20190724;

enum Figure { // static final을 모아놓은것. //Figure.으로 접근
	LINE, CIRCLE, RECT, ROUNDRECT, PEN
}

public class ShapeDTO {
	// 좌표 6개
	private int x1, y1, x2, y2, z1, z2;
	// 채우기
	private boolean fill;
	// 도형
	private Figure shape; // 0 선 1 원 2 사각형 3 둥근사각형 4 펜 staticFinal로
	// 색
	private int color;

	public ShapeDTO() {

	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public void setZ1(int z1) {
		this.z1 = z1;
	}

	public void setZ2(int z2) {
		this.z2 = z2;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public void setShape(Figure shape) {
		this.shape = shape;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

	public int getZ1() {
		return z1;
	}

	public int getZ2() {
		return z2;
	}

	public boolean getFill() {
		return fill;
	}

	public Figure getShape() {
		return shape;
	}

	public int getColor() {
		return color;
	}

}