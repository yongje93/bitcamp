package kr.co.bit;

public class Lotteria {
	private String sangpumName;
	private int sangpumDan;
	private int sangpumSu;
	private int sangpumMoney;

	public Lotteria() {
		super();
	}

	public Lotteria(String sangpumName, int sangpumDan, int sangpumSu, int sangpumMoney) {
		super();
		this.sangpumName = sangpumName;
		this.sangpumDan = sangpumDan;
		this.sangpumSu = sangpumSu;
		this.sangpumMoney = sangpumMoney;
	}

	public String getSangpumName() {
		return sangpumName;
	}

	public void setSangpumName(String sangpumName) {
		this.sangpumName = sangpumName;
	}

	public int getSangpumDan() {
		return sangpumDan;
	}

	public void setSnagpumDan(int snagpumDan) {
		this.sangpumDan = snagpumDan;
	}

	public int getSangpumSu() {
		return sangpumSu;
	}

	public void setSangpumSu(int sangpumSu) {
		this.sangpumSu = sangpumSu;
	}

	public int getSangpumMoney() {
		return sangpumMoney;
	}

	public void setSangpumMoney(int sangpumMoney) {
		this.sangpumMoney = sangpumMoney;
	}

	@Override
	public String toString() {
		return "Lotteria [sangpumName=" + sangpumName + ", snagpumDan=" + sangpumDan + ", sangpumSu=" + sangpumSu
				+ ", sangpumMoney=" + sangpumMoney + "]";
	}

}
