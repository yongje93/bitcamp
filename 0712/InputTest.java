class InputTest {
	public static void main(String[] args) {
		for(int i = 0; i < args.length; i++) {						//length�� ��ɾ�
			System.out.println("args["+i+"] = " + args[i]);
			System.out.println("ù ���� = " + args[i].charAt(0));		//charAt()�� static�Լ� �ƴ�.
			System.out.println("���ڿ� ���� = " + args[i].length());	//length()�� �Լ�
		}
		System.out.println();

		for(String data: args) {
			System.out.println("data = " + data);
		}
	}
}
