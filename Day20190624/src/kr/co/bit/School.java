package kr.co.bit;

public class School {
	protected int kor; // 국어
	protected int eng; // 영어
	protected int mat; // 수학
	protected int total; // 총합
	protected double avg;	//평균

	public School() {
		this(0, 0, 0);
	}

	public School(int kor, int eng, int mat) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int total() {
		total = kor + eng + mat;
		return total;
	}
	
	public double average() {
		avg = total / 3.0;
		return avg;
	}
	
	@Override
	public String toString() {
		return "School [국어=" + kor + ", 영어=" + eng + ", 수학=" + mat + "]";
	}
	
}
