package kr.co.bit;

public class ManSchool extends School {
	protected int gisul; // 기술

	public ManSchool() {
		super();
	}

	public ManSchool(int kor, int eng, int mat, int gisul) {
		super(kor, eng, mat);
		this.gisul = gisul;
	}

	public int getGisul() {
		return gisul;
	}

	public void setGisul(int gisul) {
		this.gisul = gisul;
	}

	@Override
	public int total() {
		return super.total() + gisul;
	}

	@Override
	public double average() {
		return this.total / 4.0;
	}

	@Override
	public String toString() {
		return super.toString() + " ManSchool [기술=" + gisul + "]" + " 총합 =" + total(); // super.toString() - 부모의 toString
	}

	public static void main(String[] args) {
		ManSchool manSchool = new ManSchool();
		manSchool.setKor(80);
		manSchool.setEng(70);
		manSchool.setMat(60);
		manSchool.setGisul(50);

		System.out.println(manSchool.toString());
	}
}
