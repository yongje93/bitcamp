package kr.co.bit.obj1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HaksaProjectTest {

	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> haksaList = new ArrayList<HashMap<String, String>>(); // arraylist 1���� �迭
																									// hashmap 2�����迭

		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("========== �޴� ���� ==========");
			System.out.println("1. ���");
			System.out.println("2. ã��");
			System.out.println("3. ����");
			System.out.println("4. ��ü ���");
			System.out.println("-----------------");
			System.out.println("0. ����");
			System.out.println("-----------------");
			System.out.println("��ȣ�� ������ �ּ���.. ");
			int protocol = input.nextInt();

			if (protocol == 1) { // ���
				System.out.println("========== �޴� ���� ==========");
				System.out.println("1. �л�");
				System.out.println("2. ����");
				System.out.println("3. ������");
				System.out.println("4. �����޴�");
				System.out.println("��ȣ�� ������ �ּ���.. ");
				protocol = input.nextInt();

				if (protocol == 1) {
					HashMap<String, String> haksaHash = new HashMap<String, String>();

					System.out.println("�л����");
					System.out.println("����: ");
					String age = input.next();
					System.out.println("�̸�: ");
					String name = input.next();
					System.out.println("�й�: ");
					String hakbun = input.next();

					haksaHash.put("age", age);
					haksaHash.put("name", name);
					haksaHash.put("hakbun", hakbun);
					haksaList.add(haksaHash);

					System.out.println("�л��� ��� �Ǿ����ϴ�.");

				} else if (protocol == 2) {
					HashMap<String, String> haksaHash = new HashMap<String, String>();

					System.out.println("�������");
					System.out.println("����: ");
					String age = input.next();
					System.out.println("�̸�: ");
					String name = input.next();
					System.out.println("����: ");
					String subject = input.next();

					haksaHash.put("age", age);
					haksaHash.put("name", name);
					haksaHash.put("subject", subject);
					haksaList.add(haksaHash);

					System.out.println("���� ��� �Ǿ����ϴ�.");

				} else if (protocol == 3) {
					HashMap<String, String> haksaHash = new HashMap<String, String>();

					System.out.println("�����ڵ��");
					System.out.println("����: ");
					String age = input.next();
					System.out.println("�̸�: ");
					String name = input.next();
					System.out.println("�μ�: ");
					String part = input.next();

					haksaHash.put("age", age);
					haksaHash.put("name", name);
					haksaHash.put("part", part);
					haksaList.add(haksaHash);

					System.out.println("������ ��� �Ǿ����ϴ�.");

				} else {
					System.out.println("�����޴�");
					continue;
				}

			} else if (protocol == 2) { // ã��
				System.out.println("ã��");
				System.out.println("�̸��� �Է��ϼ���..");
				String inputName = input.next();

				for (int i = 0; i < haksaList.size(); i++) {
					HashMap<String, String> haksaHash = haksaList.get(i);
					if (inputName.equals(haksaHash.get("name"))) {
						System.out.println("����\t�̸�\t�й�\t����\t�μ�");
						System.out.print(haksaHash.get("age") + "\t");
						System.out.print(haksaHash.get("name") + "\t");
						System.out.print(haksaHash.get("hakbun") + "\t");
						System.out.print(haksaHash.get("subject") + "\t");
						System.out.print(haksaHash.get("part") + "\n");
					}
				}

			} else if (protocol == 3) { // ����
				System.out.println("����");

			} else if (protocol == 4) { // ��ü���
				System.out.println("��ü���");
				System.out.println("����\t�̸�\t�й�\t����\t�μ�\n");
				for (int i = 0; i < haksaList.size(); i++) {
					HashMap<String, String> haksaHash = haksaList.get(i);
					System.out.print(haksaHash.get("age") + "\t");
					System.out.print(haksaHash.get("name") + "\t");
					System.out.print(haksaHash.get("hakbun") + "\t");
					System.out.print(haksaHash.get("subject") + "\t");
					System.out.print(haksaHash.get("part") + "\n");
				}

			} else if (protocol == 0) { // ����
				System.out.println("����");
				System.exit(0);

			} else {
				System.out.println("�޴� �ٽ� ����.");
			}

		}

	}

}
