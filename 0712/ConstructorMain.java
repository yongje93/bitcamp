class ConstructorMain {
	private String name;
	private int age;
	
	public ConstructorMain() {
		System.out.println("default ������");
	}

	public ConstructorMain(String name) {
		this();
		System.out.println("this = " + this);
		this.name = name;
	}

	public ConstructorMain(int age) {
		this("�ڳ�");	//Overload�� �ٸ� �����ڸ� ȣ��, ������ ù��° �ٿ� ��ġ�ؾߵȴ�.
		System.out.println("this = " + this);
		this.age = age;
	}

	public static void main(String[] args) {
		ConstructorMain aa = new ConstructorMain();	
		System.out.println("�̸�: " + aa.name + " ����: " + aa.age);
		System.out.println();
		
		ConstructorMain bb = new ConstructorMain("ȫ�浿");
		System.out.println("bb = " + bb);
		System.out.println("�̸�: " + bb.name + " ����: " + bb.age);
		System.out.println();
		
		ConstructorMain cc = new ConstructorMain(25);
		System.out.println("cc = " + cc);
		System.out.println("�̸�: " + cc.name + " ����: " + cc.age);
		System.out.println();
        
	}
}

/* 
������
��ü �ʱ�ȭ
1. 
2. returnType�� ����.
3. ������ 1���� ���� ��, �ڵ����� default �����ڰ� �帥��.

Overload�� �����ڳ����� ȣ���� ����.

*/