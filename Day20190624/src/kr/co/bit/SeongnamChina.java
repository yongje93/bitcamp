package kr.co.bit;

public class SeongnamChina extends China {
	protected int samsun; // »ï¼±Â«»Í

	public SeongnamChina() {
		super();
	}

	public SeongnamChina(int jajang, int jampong, int tang, int samsun) {
		super(jajang, jampong, tang);
		this.samsun = samsun;
	}

	public int getSamsun() {
		return samsun;
	}

	public void setSamsun(int samsun) {
		this.samsun = samsun;
	}

	@Override
	public String toString() {
		return super.toString() + "SeongnamChina [samsun=" + samsun + "]";
	}

}
