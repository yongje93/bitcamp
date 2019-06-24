package kr.co.bit;

public class SeoulChina extends China {
	protected int jengban; // Àï¹İÂ¥Àå

	public SeoulChina() {
		super();
	}

	public SeoulChina(int jajang, int jampong, int tang, int jengban) {
		super(jajang, jampong, tang);
		this.jengban = jengban;
	}

	public int getJengban() {
		return jengban;
	}

	public void setJengban(int jengban) {
		this.jengban = jengban;
	}

	@Override
	public String toString() {
		return super.toString() + "SeoulChina [jengban=" + jengban + "]";
	}

}
