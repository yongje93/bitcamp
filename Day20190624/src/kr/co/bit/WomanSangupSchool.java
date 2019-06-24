package kr.co.bit;

public class WomanSangupSchool extends WomanSchool {
	protected int sangup; //상업

	public WomanSangupSchool() {
		super();
	}

	public WomanSangupSchool(int kor, int eng, int mat, int gajung, int sangup) {
		super(kor, eng, mat, gajung);
		this.sangup = sangup;
	}

	public int getSangup() {
		return sangup;
	}

	public void setSangup(int sangup) {
		this.sangup = sangup;
	}

	@Override
	public int total() {
		return super.total() + sangup;
	}

	@Override
	public double average() {
		return this.total() / 5.0;
	}

	@Override
	public String toString() {
		return super.toString() + " WomanGongupSchool [상업=" + sangup + "]" + " 총합 =" + total();
	}
	
	public static void main(String[] args) {
		WomanSangupSchool womanGongupSchool = new WomanSangupSchool();
		womanGongupSchool.setKor(100);
		womanGongupSchool.setEng(90);
		womanGongupSchool.setMat(98);
		womanGongupSchool.setGajung(90);
		womanGongupSchool.setSangup(70);
		
		System.out.println(womanGongupSchool.toString());
		
	}

}
