class Child extends Parent {
	protected String name;
	protected int age;

	public Child(String name, int age, double weight, double height) {
		//super(weight, height);
		System.out.println("Child ������");
		this.name = name;
		this.age = age;
		super.weight = weight;//this.weight = weight;
		super.height = height;//this.height = height;
	}

	public void output() {
		System.out.println("�̸� = " + name);
		System.out.println("���� = " + age);
		//System.out.println("������ = " + weight);
		//System.out.println("Ű = " + height);
		disp(); // ȣ�� (�����׼� ã�ٰ� ������ �θ����� ��.)
	}

	public static void main(String[] args) {
		Child aa = new Child("ȫ�浿", 27, 75.8, 185.3);
		aa.output();
		System.out.println("---------------");
		aa.disp();
		System.out.println("***************");
		
		Parent bb = new Child("�ڳ�", 13, 42.7, 153.6);	// �θ� = new �ڽ�.
		//bb.output();	//output�� �ڽ�Ŭ������ �޼ҵ�. �θ𿡼� ������.
		bb.disp();
		
	}
}
