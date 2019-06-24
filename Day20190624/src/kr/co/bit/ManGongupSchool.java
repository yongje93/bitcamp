package kr.co.bit;

public class ManGongupSchool extends ManSchool {
	protected int gongup; // 공업

	public ManGongupSchool() {
		super();
	}

	public ManGongupSchool(int kor, int eng, int mat, int gisul, int gongup) {
		super(kor, eng, mat, gisul);
		this.gongup = gongup;
	}

	public int getGongup() {
		return gongup;
	}

	public void setGongup(int gongup) {
		this.gongup = gongup;
	}

	@Override
	public int total() {
		return super.total() + gongup;
	}

	@Override
	public double average() {
		return this.total() / 5.0;
	}

	@Override
	public String toString() {
		return super.toString() + " ManGongupSchool [공업=" + gongup + "]" + " 총합 =" + total();
	}

	public static void main(String[] args) {
		ManGongupSchool manGongupSchool = new ManGongupSchool();
		manGongupSchool.setKor(100);
		manGongupSchool.setEng(90);
		manGongupSchool.setMat(70);
		manGongupSchool.setGisul(100);
		manGongupSchool.setGongup(80);
	}

}
