/* ���� ���� �� ����.
	1: ���� 
	2: ����
	3: ��
	��ǻ�Ͱ� 1~3�� ������ �߻��Ѵ�. 
	���� �̰�� ����.
	
	[������]
	����, ����, ��(1~3) : 1 (System.in.read() ���)
	��ǻ�� : ����, �� : ����
	����
	0 '0' 48 ����
*/
class Game {
	public static String getName(int i) {
		if(i == 1) return "����";
		else if(i == 2)	return "����";
		else if(i == 3) return "��";
		else return "";
	}

	public static void gameProcess(String com_result, String user_result) {
		if(com_result.equals(user_result)) {
			System.out.println("����.");
		}
		if("����".equals(com_result)) {
			if("����".equals(user_result)) {
				System.out.println("�̰��.");
			} else {
				System.out.println("����.");
			}
		} else if ("����".equals(com_result)) {
			if("��".equals(user_result)) {
				System.out.println("�̰��.");
			} else {
				System.out.println("����.");
			}
		} else if ("��".equals(com_result)) {
			if("����".equals(user_result)) {
				System.out.println("�̰��.");
			} else {
				System.out.println("����.");
			}
		}
	}
	
	public static void main(String[] args) throws java.io.IOException {
		int com, user;
		com = (int)(Math.random()*3) + 1;		
		System.out.println(com);
		System.out.print("����, ����, �� (1~3) : ");	//1,2,3->49,50,51
		user = System.in.read()-48; // System.in.read-'0';
		
		String com_result = getName(com);
		String user_result = getName(user);
		System.out.println("��ǻ�� : " + com_result +", �� : " + user_result);
		
		gameProcess(com_result, user_result);
/*
		if(com == 1) {	//����
			if(user == 1) { //����
				System.out.println("��ǻ�� : ����, �� : ����");
				System.out.println("����.");
			} else if(user == 2) { //����
				System.out.println("��ǻ�� : ����, �� : ����");
				System.out.println("�̰��.");
			} else if(user == 3) { //��
				System.out.println("��ǻ�� : ����, �� : ��");
				System.out.println("����.");
			}
		} else if (com == 2) {	//����
			if(user == 1) { //����
				System.out.println("��ǻ�� : ����, �� : ����");
				System.out.println("����.");
			} else if(user == 2) { //����
				System.out.println("��ǻ�� : ����, �� : ����");
				System.out.println("����.");
			} else if(user == 3) { //��
				System.out.println("��ǻ�� : ����, �� : ��");
				System.out.println("�̰��.");
			}
		} else if (com == 3) {	//��
			if(user == 1) { //����
				System.out.println("��ǻ�� : ��, �� : ����");
				System.out.println("�̰��.");
			} else if(user == 2) { //����
				System.out.println("��ǻ�� : ��, �� : ����");
				System.out.println("����.");
			} else if(user == 3) { //��
				System.out.println("��ǻ�� : ��, �� : ��");
				System.out.println("����.");
			}
		}
		*/
	}
}
