package day20190626;

public interface Parent {
	// ��� �ʵ�
	public static final int MAX_VALUE = 100;
	public static final int MIN_VLAUE = 0;
	
	// �߻� �޼ҵ�
	public abstract void run();
	
	// ����Ʈ �޼ҵ� -> ���� ������� �ۼ��� �����ϴ�. 
	public default void setState(boolean state) {
		if(state) {
			System.out.println("���� ����");
		} else {
			System.out.println("������ ����");
		}
	}
	
	// ���� �޼ҵ�
	public static void change() {
		System.out.println("���¸� �����մϴ�.");
	}
}
