class Outer {
	private String name;
	
	public void output() {
		System.out.println("�̸� = " + this.name + " ���� = " + new Inner().age);
	}

	class Inner {	// has~a ����
		private int age;

		public void disp() {
			System.out.println("�̸� = " + Outer.this.name + " ���� = " + this.age);
		}
	}
	
	public static void main(String[] args) {
		Outer aa = new Outer();
		aa.name = "ȫ�浿";
		aa.output();

		Outer.Inner bb = aa.new Inner();
		//bb.name = "�ڳ�";	//static���� ������ �����̶� ���پȵ�.
		bb.age = 25;
		bb.disp();

		Outer.Inner cc = aa.new Inner();
		cc.age = 30;
		cc.disp();

		Outer.Inner dd = new Outer().new Inner(); 
		dd.age = 35;
		dd.disp();	//������ name�� �ȳ־��༭ null ���´�.

	}
}
