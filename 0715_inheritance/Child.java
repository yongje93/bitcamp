class Child extends Parent {
	protected String name;
	protected int age;

	public Child(String name, int age, double weight, double height) {
		//super(weight, height);
		System.out.println("Child 생성자");
		this.name = name;
		this.age = age;
		super.weight = weight;//this.weight = weight;
		super.height = height;//this.height = height;
	}

	public void output() {
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
		//System.out.println("몸무게 = " + weight);
		//System.out.println("키 = " + height);
		disp(); // 호출 (나한테서 찾다가 없으면 부모한테 감.)
	}

	public static void main(String[] args) {
		Child aa = new Child("홍길동", 27, 75.8, 185.3);
		aa.output();
		System.out.println("---------------");
		aa.disp();
		System.out.println("***************");
		
		Parent bb = new Child("코난", 13, 42.7, 153.6);	// 부모 = new 자식.
		//bb.output();	//output은 자식클래스의 메소드. 부모에서 사용못함.
		bb.disp();
		
	}
}
