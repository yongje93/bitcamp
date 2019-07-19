import java.text.DecimalFormat;

public class SungJukDTO implements Comparable<SungJukDTO> {
	private int no; // 번호
	private String name; // 이름
	private int korea; // 국어
	private int english; // 영어
	private int math; // 수학
	private int total;
	private double avg;

	public SungJukDTO(int no, String name, int korea, int english, int math) {
		super();
		this.no = no;
		this.name = name;
		this.korea = korea;
		this.english = english;
		this.math = math;
		total = korea + english + math;
		avg = total / 3.0;
	}

	public int getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public int getKorea() {
		return korea;
	}

	public int getEnglish() {
		return english;
	}

	public int getMath() {
		return math;
	}

	public int getTotal() {
		return total;
	}

	public double getAvg() {
		return avg;
	}

	@Override
	public String toString() {
		return no + "\t" + name + "\t" + korea + "\t" + english + "\t" + math + "\t" + total + "\t" + new DecimalFormat("#.###").format(avg);
	}

	@Override
	public int compareTo(SungJukDTO o) {
		// 내림차순
		if(this.getTotal() < o.getTotal()) return 1;
		else if(this.getTotal() > o.getTotal()) return -1;
		else return 0;
	}
}
