class Person {
	private String name;
	private int age;

	public void setName(String n) {	//구현
		name = n;
	}

	public void setAge(int n) {	//구현
		age = n;
	}

	public void setData(String n, int a) {
		name = n;
		age = a;
	}

	public void setData() { }	// 오버로드

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}
//---------------
class PersonMain {
	public static void main(String[] args) {
		Person aa;	
		aa = new Person();
		System.out.println("객체 aa = " + aa);
		System.out.println("객체 aa = " + aa.toString());
		System.out.println("객체 aa = " + aa.hashCode());	//10진수로 바꿔준다.
		
		aa.setName("홍길동"); //호출
		System.out.println("이름=" + aa.getName());
		aa.setAge(27);
		System.out.println("나이=" + aa.getAge());	
		System.out.println();
		//-------------------
		
		Person bb = new Person();
		System.out.println("객체 bb = " + bb);
		bb.setName("코난");
		System.out.println("이름=" + bb.getName());
		bb.setAge(15);
		System.out.println("나이=" + bb.getAge());
		System.out.println();

		Person cc = new Person();
		cc.setData("또치", 30);
		System.out.println("이름=" + cc.getName());
		System.out.println("나이=" + cc.getAge());
		System.out.println();

		Person dd = new Person();
		dd.setData();
		System.out.println("이름=" + dd.getName());
		System.out.println("나이=" + dd.getAge());
		System.out.println();
	}
}

// int aa; //정수형 변수	int[] ar; //정수형 배열
// double aa; //실수형 변수
// Person aa; // 객체	Person[] ar; //객체 배열