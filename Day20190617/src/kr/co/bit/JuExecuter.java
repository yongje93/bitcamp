package kr.co.bit;

public class JuExecuter {

	public static void main(String[] args) {
		System.out.println("�ֹ����� y/n");
		char ju = args[0].charAt(0);	//charAt�� ���ؼ� �ѹ��ڷ� �����´�. ""���� ''��
		if(ju == 'y' || ju == 'Y') {	//�ֹ�����
			System.out.println("�ֹ�����");
			System.out.println("�޴� 1.¥��� 2.«�� 3.������");
			int menu = Integer.parseInt(args[1]);
			if(menu == 1) {
				System.out.println("¥��� ����");
				System.out.println("¥��� ����� y/n");
				char gob = args[2].charAt(2);
				if(gob=='y'||gob=='Y') {
					System.out.println("¥��� ����� ����");
				} else {
					System.out.println("¥��� ���� ����");
				}
			} else if(menu == 2) {
				System.out.println("«�� ����");
				char gob = args[2].charAt(2);
				if(gob=='y'||gob=='Y') {
					System.out.println("«�� ����� ����");
				} else {
					System.out.println("«�� ���� ����");
				}
			} else if(menu == 3) {
				System.out.println("������ ����");
				System.out.println("������ 1.�� 2.�� 3.��");
				int tang = Integer.parseInt(args[2]);
				if(tang == 1) {
					System.out.println("������ ��");
				} else if (tang == 2) {
					System.out.println("������ ��");
				} else if (tang == 3) {
					System.out.println("������ ��");
				} else {
					System.out.println("������ ���߼� ����");
				}
			} else {
				System.out.println("1,2,3 �߿� �����ϼ���.");
			}
		} else {	//�ֹ����
			System.out.println("�ֹ����");
		}
		
	}

}
