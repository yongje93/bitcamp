class InputTest {
	public static void main(String[] args) {
		for(int i = 0; i < args.length; i++) {						//length는 명령어
			System.out.println("args["+i+"] = " + args[i]);
			System.out.println("첫 문자 = " + args[i].charAt(0));		//charAt()은 static함수 아님.
			System.out.println("문자열 길이 = " + args[i].length());	//length()는 함수
		}
		System.out.println();

		for(String data: args) {
			System.out.println("data = " + data);
		}
	}
}
