package kr.co.bit;

class Student1 {
	SchoolType school;

	public Student1(SchoolType school) {
		this.school = school;
	}

}

enum SchoolType {	//1, 2, 3, 4
	ELEMENTARY, MIDDLE, HIGH, UNIVERSITY
}

public class EnumTest2 {

	public static void main(String[] args) {
		Student1 st1 = new Student1(SchoolType.ELEMENTARY);
		System.out.println("상수값을 출력한 경우");
		System.out.println("st1.school = " + st1.school);
		if (st1.school == SchoolType.ELEMENTARY) {
			System.out.println("당신은 초등학생입니다.");
		}

	}

}
