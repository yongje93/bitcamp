package kr.co.bit;

public class JuExecuter {
	public static void main(String[] args) {
		System.out.println("�ֹ��ϼ���. y/n");
		char ju = 'y';
		if (ju == 'y' || ju == 'Y') {
			System.out.println("�ֹ�����");
			System.out.println("�޴� 1.¥��� 2.«�� 3.������");
			int menu = 1;
			switch(menu) {	//��ø switch�� �� �Ⱦ�.
				case 1:
					System.out.println("¥��� ����");
					System.out.println("¥��� ����� y/n");
					char gob = 'y';
					if(gob == 'y' || gob == 'Y') {
						System.out.println("¥��� ����� ����");
					} else {
						System.out.println("¥��� ���� ����");
					}
					break;
				case 2:
					System.out.println("«�� ����");
					System.out.println("«�� ����� y/n");
					gob = 'y';
					if(gob == 'y' || gob == 'Y') {
						System.out.println("«�� ����� ����");
					} else {
						System.out.println("«�� ���� ����");
					}
					break;
				case 3:
					System.out.println("������ ����");
					System.out.println("1.�� 2.�� 3.�� ����");
					int tang = 1;
					switch(tang) {
						case 1:
							System.out.println("������ ��");
							break;
						case 2:
							System.out.println("������ ��");
							break;
						case 3:
							System.out.println("������ ��");
							break;
						default:
							System.out.println("1,2,3 �߿� �����ϼ���.");
					}
					break;
				default:
					System.out.println("1, 2, 3 �߿� �����ϼ���.");
			}
		} else {
			System.out.println("�ֹ����");
		}
	}
}
