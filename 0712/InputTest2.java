class InputTest2 {
	public static void main(String[] args) throws java.io.IOException {
		System.out.print("���� �Է� : ");
		int data = System.in.read();	// �ѱ��ڹۿ� ������.
		System.in.read();	// flush �������°� ���а�����.
		System.in.read();	// \r�̶� \n�о���.
		System.out.print("���� �Է� : ");
		int data2 = System.in.read();	

		System.out.println(data +", "+ data2);
		
	}
}

// ���� \r\n ���.