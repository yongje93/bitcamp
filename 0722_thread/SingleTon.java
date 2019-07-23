class SingleTon {
	private int num = 3;
	private static SingleTon instance;	// �� �ڽ��� ��ü�� ��Ÿ��.

	public static SingleTon getInstance() {
		if(instance == null) { // ��ó���� ���ѹ��� ������.
			synchronized(SingleTon.class) {	//Ŭ���� Ÿ������ ���ɷ��� �ϳ��� �����. ������ ���͵�.
				instance = new SingleTon();
			}
		}
		return instance;	//�̹� ������ �Ǿ �׳� instance ���� ������. 
	}

	public static void main(String[] args) {
		/*
		SingleTon aa = new SingleTon();
		aa.num++;
		System.out.println("aa = " + aa);
		System.out.println("num = " + aa.num);
		System.out.println();
		
		SingleTon bb = new SingleTon();
		bb.num++;
		System.out.println("bb = " + aa);
		System.out.println("num = " + bb.num);
		System.out.println();
		*/
		SingleTon cc = SingleTon.getInstance();	// new �ϸ� SingleTon �ȵ�.
		cc.num++;
		System.out.println("cc = " + cc);
		System.out.println("num = " + cc.num);
		System.out.println();

		SingleTon dd = SingleTon.getInstance();
		dd.num++;
		System.out.println("dd = " + dd);
		System.out.println("num = " + dd.num);
		System.out.println();
	}
}
