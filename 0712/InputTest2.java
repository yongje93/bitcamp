class InputTest2 {
	public static void main(String[] args) throws java.io.IOException {
		System.out.print("문자 입력 : ");
		int data = System.in.read();	// 한글자밖에 못읽음.
		System.in.read();	// flush 쓸데없는걸 못읽게해줌.
		System.in.read();	// \r이랑 \n읽어줌.
		System.out.print("문자 입력 : ");
		int data2 = System.in.read();	

		System.out.println(data +", "+ data2);
		
	}
}

// 엔터 \r\n 기능.