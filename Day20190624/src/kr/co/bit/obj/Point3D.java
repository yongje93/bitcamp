package kr.co.bit.obj;

public class Point3D extends Point2D {
	protected int z;

	public Point3D() {
		super();
	}

	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	@Override
	public String toString() {
		return super.toString() + " Point3D [z=" + z + "]";
	}

	public static void main(String[] args) {
		Point3D point3D = new Point3D();
		point3D.x = 10;
		point3D.y = 20;
		point3D.z = 30;
		System.out.println(point3D.toString());
	}
}
