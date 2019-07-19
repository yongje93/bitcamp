import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class SungJukAction {
	private ArrayList<SungJukDTO> list = new ArrayList<SungJukDTO>();;
	private Scanner scan = new Scanner(System.in);

	public void menu() {
		int number; // ���ù�ȣ
		while (true) {
			System.out.println("\n------------------");
			System.out.println("   1.�Է�\n   2.���\n   3.�˻�\n   4.����\n   5.����\n   6.��");
			System.out.println("------------------");
			System.out.print("��ȣ : ");
			number = scan.nextInt();
			System.out.println();

			if (number == 1) { // �Է�
				insertArticle();
			} else if (number == 2) { // ���
				printArticle();
			} else if (number == 3) { // �˻�
				searchArticle();
			} else if (number == 4) { // ����
				deleteArticle();
			} else if (number == 5) { // ����
				sortArticle();
			} else if (number == 6) { // ��
				break;
			} else {
				System.out.println("1~6 �߿� �����ϼ���.");
			}
		}
	}

	public void insertArticle() {
		System.out.print("��ȣ �Է� : ");
		int no = scan.nextInt();
		System.out.print("�̸� �Է� : ");
		String name = scan.next();
		System.out.print("���� �Է� : ");
		int korea = scan.nextInt();
		System.out.print("���� �Է� : ");
		int english = scan.nextInt();
		System.out.print("���� �Է� : ");
		int math = scan.nextInt();

		SungJukDTO dto = new SungJukDTO(no, name, korea, english, math);
		list.add(dto);
	}

	public void printArticle() {
		System.out.print("��ȣ\t�̸�\t����\t����\t����\t����\t���\n");
		for (SungJukDTO dto : list) {
			System.out.println(dto);
		}
		System.out.println();
	}

	public void searchArticle() {
		int count = 0;
		System.out.print("�˻� �� �̸� �Է� : ");
		String name = scan.next();
		for (SungJukDTO data : list) {
			if (name.equals(data.getName())) {
				count++;
				if (count == 1)
					System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
				System.out.println(data);
			}
		}
		if (count == 0) {
			System.out.println("ã���� �ϴ� �̸��� �����ϴ�.");
		}
	}

	public void deleteArticle() {
		System.out.print("���� �� �̸� �Է� : ");
		String name = scan.next();
		int sw = 0; // switch
		Iterator<SungJukDTO> it = list.iterator();
		while (it.hasNext()) {
			SungJukDTO dto = it.next();
			if (dto.getName().equals(name)) {
				it.remove(); // remove �޼ҵ�� next()�� ȣ���� �����͸� �����մϴ�.
				sw = 1;
			}
		}
		if (sw == 0) {
			System.out.println("������ �̸��� �����ϴ�.");
		} else {
			System.out.println("�����͸� �����Ͽ����ϴ�.");
		}
	}

	public void sortArticle() {
		while (true) {
			System.out.println("1. �̸����� ��������");
			System.out.println("2. �������� ��������");
			System.out.println("3. �����޴�");
			System.out.print(" ��ȣ �Է�: ");
			int number = scan.nextInt();
			
			System.out.println();
			
			if (number == 1) {
				Comparator<SungJukDTO> sortName = new Comparator<SungJukDTO>() {
					@Override
					public int compare(SungJukDTO o1, SungJukDTO o2) {
						return o1.getName().compareTo(o2.getName());
					}
				};
				Collections.sort(list, sortName);
				printArticle();
			} else if (number == 2) {
				Collections.sort(list);
				printArticle();
			} else if (number == 3) {
				break;
			}
		}
	}
}