package day20190626;

public class InterfaceTest implements Parent {

	@Override
	public void run() { // �߻�޼ҵ� ����
		System.out.println("�߻�޼ҵ� ����");
	}

	public void setState(boolean state) {
		System.out.println("�������̽��� ����Ʈ �޼ҵ� ������");
	}

	public static void main(String[] args) {
		
		boolean state = true;
		
		Parent parent = new Parent() {
			public void run() {
				System.out.println("�͸�ü ����");
			}
		};
		
		parent.run();	// �͸� ��ü ����
		
		Parent.change();	// ���� �޼ҵ� ����
		
		InterfaceTest test = new InterfaceTest();
		test.setState(state);	// ����Ʈ �޼ҵ� ������
	
	}

}
