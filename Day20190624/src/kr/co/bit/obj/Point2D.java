package kr.co.bit.obj;

public class Point2D {
	protected int x;
	protected int y;

	public Point2D() {
		super();
	}

	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point2D [x=" + x + ", y=" + y + "]";
	}

}
