class Sub extends Parent {
	protected String name;
	protected int age;

	public Sub(String name, int age, double weight, double height) {
		super(weight, height);	// 부모생성자 호출

		System.out.println("Sub 생성자");
		this.name = name;
		this.age = age;
	}

	@Override
	public void disp() { //메소드 오버라이드
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
		super.disp(); //부모의 것이라고 알려줘야됨.
	}

	public static void main(String[] args) {
		Sub aa = new Sub("홍길동", 27, 75.8, 185.3);
		aa.disp();
		System.out.println("---------------");
		Parent bb = new Sub("코난", 13, 42.7, 153.6);
		bb.disp();
	}
}
