class Variable {
	public static void main(String[] args) {
		//����
		//�ڷ���
		boolean a;	//1bit
		a = 25>36;	
		System.out.println("a=" + a);
		
		char b;	//2byte
		b = 'A';
		System.out.println("b=" + b);

		int c;
		c = 65;
		System.out.println("c=" + c);
	
		int d;
		d = 'A'; //65
		System.out.println("d=" + d);

		char e;
		e = 65;	//'A'
		System.out.println("e=" + e);

		float f;
		f = 43.8f;	// �ڹٿ��� �Ǽ��� default�� double�̶� float�̸� ĳ���� ����ߵ�.
		System.out.println("f=" + f);
	}
}