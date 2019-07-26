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
	private int shape; // 0 선 1 원 2 사각형 3 둥근사각형 4 펜 staticFinal로
	// 색
	private int color;

	public ShapeDTO(int x1, int y1, int x2, int y2, int z1, int z2, boolean fill, int shape, int color) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.z1 = z1;
		this.z2 = z2;
		this.fill = fill;
		this.shape = shape;
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

	public int getShape() {
		return shape;
	}

	public int getColor() {
		return color;
	}

}