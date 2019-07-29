public class ScoreDTO implements java.io.Serializable, Comparable<ScoreDTO> {	//객체를 파일에 저장하기 위해서 직렬화가 필요함.
	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;

	public ScoreDTO(String hak, String name, int kor, int eng, int math) {
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getHak() {
		return hak;
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public int getTot() {
		return tot;
	}

	public double getAvg() {
		return avg;
	}

	public void calc() {
		tot = kor + eng + math;
		avg = tot / 3.0;
	}

	@Override
	public String toString() {
		return String.format("%6s %6s %5d %5d %5d %5d %9.3f", hak, name, kor, eng, math, tot, avg);
	}

	@Override
	public int compareTo(ScoreDTO o) {	//내림차순
		if(this.getTot() < o.getTot()) return 1;
		else if (this.getTot() > o.getTot()) return -1;
		else return 0;
	}

}
