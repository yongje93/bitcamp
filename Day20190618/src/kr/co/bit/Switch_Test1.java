package kr.co.bit;

public class Switch_Test1 {

	public static void main(String[] args) {
		String job = args[0];
		int salary = 0;
		switch (job) {
			case "���":
				salary = 20000000;
				break;
			case "�븮":
				salary = 35000000;
				break;
			case "����":
				salary = 50000000;
				break;
			case "����":
				salary = 80000000;
				break;
			default:
				System.out.println("���, �븮, ����, ���� �� �Է��ϼ���.");
		}
		System.out.println("����� ������ " + salary + "�� �Դϴ�.");
	}
}
