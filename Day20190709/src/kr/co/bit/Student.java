package kr.co.bit;

public class Student {
	private String name;
	private String gender;
	private int scroe;

	public Student(String name, String gender, int scroe) {
		super();
		this.name = name;
		this.gender = gender;
		this.scroe = scroe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getScroe() {
		return scroe;
	}

	public void setScroe(int scroe) {
		this.scroe = scroe;
	}

}
