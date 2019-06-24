package kr.co.bit;

public class WomanSchool extends School {
	protected int gajung; // 가정

	public WomanSchool() {
		super();
	}

	public WomanSchool(int kor, int eng, int mat, int gajung) {
		super(kor, eng, mat);
		this.gajung = gajung;
	}

	public int getGajung() {
		return gajung;
	}

	public void setGajung(int gajung) {
		this.gajung = gajung;
	}

	@Override
	public int total() {
		return super.total() + gajung;
	}
	
	@Override
	public double average() {
		return this.total() / 4.0;
	}

	@Override
	public String toString() {
		return super.toString() + " WomanSchool [가정=" + gajung + "]" + " 총합=" + total();
	}
	
	public static void main(String[] args) {
		WomanSchool womanSchool = new WomanSchool();
		womanSchool.setKor(90);
		womanSchool.setEng(80);
		womanSchool.setMat(70);
		womanSchool.setGajung(60);

		System.out.println(womanSchool.toString());
	}
}
