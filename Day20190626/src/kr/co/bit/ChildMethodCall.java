package kr.co.bit;

public class ChildMethodCall {
	
	public static void main(String[] args) {
		Person person = new Student();	// �θ� �ڽ��� ����. (���)
		//person.study();			// �ڽĿ��� �����ϴ� �Ϲ��Լ�
		person.showSleepStyle();	// override �Լ�				
	}
	
}
