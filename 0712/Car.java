/*
�������� ���α׷�
���࿡ �����Ǿ������� true, ���� ������ false

[������]
**************
	1.����
	2.����
	3.����Ʈ ����
	4.��
*************
	��ȣ: 4
	���α׷� ����
1���� ���
��ġ �Է� : 3	 �迭�δ� 2����
�̹� ���� �Ǿ��ֽ��ϴ�.
�Ǵ�
��ġ �Է� : 3
3�� ��ġ ����

2���� ���
��ġ �Է� : 3	
�����Ǿ� �ִ� ���� �����ϴ�.
�Ǵ�
��ġ �Է� : 3
3�� ��ġ ����

3���� ���
1 ��ġ : false
2 ��ġ : false
3 ��ġ : false
4 ��ġ : false
5 ��ġ : false
*/
import java.util.Scanner;

class Car {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean[] ar = new boolean[5]; // ������ �迭
		int protocol; // �Է� ��ȣ
		int park; // ���� ��ġ

		while (true) {
			System.out.println();
			System.out.println("****************");
			System.out.println("1.����\n2.����\n3.����Ʈ ����\n4.��");
			System.out.println("****************");
			System.out.print("��ȣ �Է�: ");
			protocol = scan.nextInt();
			System.out.println();

			if (protocol == 1) {
				System.out.print("��ġ �Է�: ");
				park = scan.nextInt();
				if (ar[park - 1] == true) { // ������ �Ǿ��������
					System.out.println("�̹� ���� �Ǿ��ֽ��ϴ�.");
				} else { // ������ �ȵǾ��������
					ar[park - 1] = true;
					System.out.println(park + "�� ��ġ ����");
				}
			} else if (protocol == 2) {
				System.out.print("��ġ �Է�: ");
				park = scan.nextInt();
				if (ar[park - 1] == true) { // ������ �Ǿ��������
					ar[park - 1] = false;
					System.out.println(park + "�� ��ġ ����");
				} else { // ������ �ȵǾ��������
					System.out.println("�����Ǿ� �ִ� ���� �����ϴ�.");
				}
			} else if (protocol == 3) {
				for (int i = 0; i < ar.length; i++) {
					System.out.println((i + 1) + " ��ġ : " + ar[i]);
				}
			} else if (protocol == 4) {
				System.out.println("���α׷� ����");
				System.exit(0);
			} else {
				System.out.println("1 ~ 4 �� �ϳ��� ������.");
			}
		}
	}
}
