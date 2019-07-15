class ConstructorMain {
	private String name;
	private int age;
	
	public ConstructorMain() {
		System.out.println("default 생성자");
	}

	public ConstructorMain(String name) {
		this();
		System.out.println("this = " + this);
		this.name = name;
	}

	public ConstructorMain(int age) {
		this("코난");	//Overload된 다른 생성자를 호출, 무조건 첫번째 줄에 위치해야된다.
		System.out.println("this = " + this);
		this.age = age;
	}

	public static void main(String[] args) {
		ConstructorMain aa = new ConstructorMain();	
		System.out.println("이름: " + aa.name + " 나이: " + aa.age);
		System.out.println();
		
		ConstructorMain bb = new ConstructorMain("홍길동");
		System.out.println("bb = " + bb);
		System.out.println("이름: " + bb.name + " 나이: " + bb.age);
		System.out.println();
		
		ConstructorMain cc = new ConstructorMain(25);
		System.out.println("cc = " + cc);
		System.out.println("이름: " + cc.name + " 나이: " + cc.age);
		System.out.println();
        
	}
}

/* 
생성자
객체 초기화
1. 
2. returnType가 없다.
3. 생성자 1개도 없을 때, 자동으로 default 생성자가 흐른다.

Overload된 생성자끼리는 호출이 가능.

*/