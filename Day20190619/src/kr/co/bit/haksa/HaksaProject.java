package kr.co.bit.haksa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HaksaProject {

	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> haksaList = new ArrayList<HashMap<String, String>>(); // arraylist 1���� �迭
																									// hashmap 2�����迭
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("========�޴� ����========");
			System.out.println("1.��� ");
			System.out.println("2.ã�� ");
			System.out.println("3.���� ");
			System.out.println("4.��ü��� ");
			System.out.println("----------------");
			System.out.println("0.����");
			System.out.println("----------------");
			System.out.print("��ȣ�� ���� ���ּ���.. ");
			int protocol = input.nextInt();

			if (protocol == 1) {
				System.out.println("���");
				System.out.println("========�޴� ����========");
				System.out.println("1.�л�");
				System.out.println("2.����");
				System.out.println("3.������");
				System.out.println("4.�����޴�");
				System.out.print("��ȣ�� ���� ���ּ���.. ");
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
					haksaHash.put("gubun", "1"); // 1�� �л�, 2�� ����, 3�� ������ �����ϱ� ���� Ű.
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
					haksaHash.put("gubun", "2");
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
					haksaHash.put("gubun", "3");
					haksaList.add(haksaHash);

					System.out.println("������ ��� �Ǿ����ϴ�.");

				} if (protocol == 4) {
					System.out.println("�����޴�");
					continue;
				}
			} else if (protocol == 2) {
				System.out.println("ã��");
				System.out.println("�̸��� �Է��ϼ���..");
				String inputName = input.next();

				for (int i = 0; i < haksaList.size(); i++) {
					HashMap<String, String> haksaHash = haksaList.get(i);
					if (inputName.equals(haksaHash.get("name"))) {
						if (haksaHash.get("gubun").equals("1")) {
							System.out.println("����\t�̸�\t�й�");
							System.out.print(haksaHash.get("age") + "\t");
							System.out.print(haksaHash.get("name") + "\t");
							System.out.print(haksaHash.get("hakbun") + "\n");
						}
						else if (haksaHash.get("gubun").equals("2")) {
							System.out.println("����\t�̸�\t����");
							System.out.print(haksaHash.get("age") + "\t");
							System.out.print(haksaHash.get("name") + "\t");
							System.out.print(haksaHash.get("subject") + "\n");
						}
						else if (haksaHash.get("gubun").equals("3")) {
							System.out.println("����\t�̸�\t�μ�");
							System.out.print(haksaHash.get("age") + "\t");
							System.out.print(haksaHash.get("name") + "\t");
							System.out.print(haksaHash.get("part") + "\n");
						}
					}
				}

			} else if (protocol == 3) {
				System.out.println("����");
				System.out.println("������ �̸� �Է�..");
				String nameDelete = input.next();
				for (int i = 0; i < haksaList.size(); i++) {
					HashMap<String, String> haksaHash = haksaList.get(i);
					if (nameDelete.equals(haksaHash.get("name"))) {
						if (haksaHash.get("gubun").equals("1")) { // �л�����
							haksaList.remove(i);
							System.out.println("�л�"+nameDelete + "���� �����Ǿ����ϴ�.");
						} else if (haksaHash.get("gubun").equals("2")) { // ��������
							haksaList.remove(i);
							System.out.println("����"+nameDelete + "���� �����Ǿ����ϴ�.");
						} else if (haksaHash.get("gubun").equals("3")) { // �����ڻ���
							haksaList.remove(i);
							System.out.println("������"+nameDelete + "���� �����Ǿ����ϴ�.");
						}
					}
				}

			} else if (protocol == 4) {
				System.out.println("��ü���");
				System.out.println("����\t�̸�\t�й�\t����\t�μ�");
				for (int i = 0; i < haksaList.size(); i++) {
					HashMap<String, String> haksaHash = haksaList.get(i);

					if (haksaHash.get("gubun").equals("1")) { // �л����
						System.out.print(haksaHash.get("age") + "\t");
						System.out.print(haksaHash.get("name") + "\t");
						System.out.print(haksaHash.get("hakbun") + "\n");

					} else if (haksaHash.get("gubun").equals("2")) { // �������
						System.out.print(haksaHash.get("age") + "\t");
						System.out.print(haksaHash.get("name") + "\t\t");
						System.out.print(haksaHash.get("subject") + "\n");

					} else if (haksaHash.get("gubun").equals("3")) { // ���������
						System.out.print(haksaHash.get("age") + "\t");
						System.out.print(haksaHash.get("name") + "\t\t\t");
						System.out.print(haksaHash.get("part") + "\n");
					}
				}
			} else if (protocol == 0) {
				System.out.println("�����մϴ�.");
				System.exit(0); // ���α׷� ����
			} else {
				System.out.println("�޴��� �ٽ� �������ּ���.");
			}
		}

	}

}
