package kr.co.bit;

public class Logic5 {
	public static void main(String[] args) {
		String id = args[0];
		String pw = args[1];
		
		if(!id.contentEquals("java")) {
			System.out.println("����� �츮 ȸ���� �ƴմϴ�.");
		} else if(!pw.equals("java")) {
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		} else {
			System.out.println("ȯ���մϴ�.");
		}
	}
}
