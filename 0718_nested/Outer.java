class Outer {
	private String name;
	
	public void output() {
		System.out.println("이름 = " + this.name + " 나이 = " + new Inner().age);
	}

	class Inner {	// has~a 관계
		private int age;

		public void disp() {
			System.out.println("이름 = " + Outer.this.name + " 나이 = " + this.age);
		}
	}
	
	public static void main(String[] args) {
		Outer aa = new Outer();
		aa.name = "홍길동";
		aa.output();

		Outer.Inner bb = aa.new Inner();
		//bb.name = "코난";	//static으로 독립된 공간이라서 접근안됨.
		bb.age = 25;
		bb.disp();

		Outer.Inner cc = aa.new Inner();
		cc.age = 30;
		cc.disp();

		Outer.Inner dd = new Outer().new Inner(); 
		dd.age = 35;
		dd.disp();	//데이터 name은 안넣어줘서 null 나온다.

	}
}
