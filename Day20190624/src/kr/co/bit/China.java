package kr.co.bit;

public class China {
	protected int jajang; // Â¥Àå¸é
	protected int jampong; // Â«»Í
	protected int tang; // ÅÁ¼öÀ°

	public China() {

	}

	public China(int jajang, int jampong, int tang) {
		this.jajang = jajang;
		this.jampong = jampong;
		this.tang = tang;
	}

	public int getJajang() {
		return jajang;
	}

	public void setJajang(int jajang) {
		this.jajang = jajang;
	}

	public int getJampong() {
		return jampong;
	}

	public void setJampong(int jampong) {
		this.jampong = jampong;
	}

	public int getTang() {
		return tang;
	}

	public void setTang(int tang) {
		this.tang = tang;
	}

	@Override
	public String toString() {
		return "China [jajang=" + jajang + ", jampong=" + jampong + ", tang=" + tang + "]";
	}

}
