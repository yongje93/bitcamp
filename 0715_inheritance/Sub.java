class Sub extends Parent {
	protected String name;
	protected int age;

	public Sub(String name, int age, double weight, double height) {
		super(weight, height);	// �θ������ ȣ��

		System.out.println("Sub ������");
		this.name = name;
		this.age = age;
	}

	@Override
	public void disp() { //�޼ҵ� �������̵�
		System.out.println("�̸� = " + name);
		System.out.println("���� = " + age);
		super.disp(); //�θ��� ���̶�� �˷���ߵ�.
	}

	public static void main(String[] args) {
		Sub aa = new Sub("ȫ�浿", 27, 75.8, 185.3);
		aa.disp();
		System.out.println("---------------");
		Parent bb = new Sub("�ڳ�", 13, 42.7, 153.6);
		bb.disp();
	}
}
