class SingleTon {
	private int num = 3;
	private static SingleTon instance;	// 나 자신의 객체를 나타냄.

	public static SingleTon getInstance() {
		if(instance == null) { // 맨처음에 딱한번만 수행함.
			synchronized(SingleTon.class) {	//클래스 타입으로 락걸려서 하나만 통과함. 여러개 들어와도.
				instance = new SingleTon();
			}
		}
		return instance;	//이미 수행이 되어서 그냥 instance 값을 가져감. 
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
		SingleTon cc = SingleTon.getInstance();	// new 하면 SingleTon 안됨.
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
