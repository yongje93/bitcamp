class Variable2 {
	int a;	//필드, 초기화
	static int b;
	String str;

	public static void main(String[] args) {
		int a = 10;	//지역변수(local variable), 쓰레기값(반드시 초기화 해줘야됨.)
		System.out.println("지역변수 a=" + a);
		System.out.println("필드 a=" + new Variable2().a);			// 인스턴스 생성 힙영역에 1개
		System.out.println("필드 b=" + b);
		System.out.println("필드 str=" + new Variable2().str);		// 인스턴스 생성 힙영역에 1개 = 총2개
	}
}


