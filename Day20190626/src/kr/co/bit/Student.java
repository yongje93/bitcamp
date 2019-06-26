package kr.co.bit;

public class Student extends Person {
	private String schoolKind;
	private String grade;

	public Student() {
		this(null, null);
	}

	public Student(String schoolKind, String grade) {
		this.schoolKind = schoolKind;
		this.grade = grade;
	}

	public String getSchoolKind() {
		return schoolKind;
	}

	public void setSchoolKind(String schoolKind) {
		this.schoolKind = schoolKind;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public void showSleepStyle() {
		System.out.println("�л����� ���� ��Ÿ���� ��Ģ���̴�.");
	}

	@Override
	public String toString() {
		return "Student [schoolKind=" + schoolKind + ", grade=" + grade + "]";
	}
	
}
