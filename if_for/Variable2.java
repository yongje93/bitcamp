class Variable2 {
	int a;	//�ʵ�, �ʱ�ȭ
	static int b;
	String str;

	public static void main(String[] args) {
		int a = 10;	//��������(local variable), �����Ⱚ(�ݵ�� �ʱ�ȭ ����ߵ�.)
		System.out.println("�������� a=" + a);
		System.out.println("�ʵ� a=" + new Variable2().a);			// �ν��Ͻ� ���� �������� 1��
		System.out.println("�ʵ� b=" + b);
		System.out.println("�ʵ� str=" + new Variable2().str);		// �ν��Ͻ� ���� �������� 1�� = ��2��
	}
}


