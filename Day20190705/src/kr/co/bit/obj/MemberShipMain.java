package kr.co.bit.obj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MemberShipMain {
	private static String session;

	static {
		session = null;
	}

	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> memberArray = new ArrayList<HashMap<String, String>>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			while (true) {
				System.out.println("R: ȸ������  L: ȸ�����  S: IDã��  D: ȸ��Ż��  E: ȸ������  I: �α���  O: �α׾ƿ�");
				String protocol = br.readLine();
				if (protocol.equals("R") | protocol.equals("r")) { // ȸ������
					if (session != null) {
						System.out.println("�α������Դϴ�.");
						continue;
					}
					HashMap<String, String> memberHash = new HashMap<String, String>();

					System.out.print("���̵� �Է�: ");
					String id = br.readLine();
					System.out.print("�н����� �Է�: ");
					String passwd = br.readLine();
					System.out.print("�ּ� �Է�: ");
					String address = br.readLine();
					System.out.print("��ȭ��ȣ �Է�: ");
					String tel = br.readLine();

					memberHash.put("id", id);
					memberHash.put("passwd", passwd);
					memberHash.put("address", address);
					memberHash.put("tel", tel);
					memberArray.add(memberHash);

					System.out.println("ȸ����� �Ǿ����ϴ�.");

				} else if (protocol.equals("L") | protocol.equals("l")) { // ȸ�����
					System.out.println("��ü���");
					System.out.print("ȸ�����̵�\tȸ���н�����\tȸ���ּ�\tȸ����ȭ��ȣ\n");
					for (int i = 0; i < memberArray.size(); i++) {
						HashMap<String, String> memberHash = memberArray.get(i);
						System.out.print(memberHash.get("id") + "\t" + memberHash.get("passwd") + "\t\t"
								+ memberHash.get("address") + "\t" + memberHash.get("tel") + "\n");
					}
				} else if (protocol.equals("S") | protocol.equals("s")) { // ȸ��ã��
					System.out.print("ã�� ���̵� �Է�: ");
					String id = br.readLine();
					for (int i = 0; i < memberArray.size(); i++) {
						HashMap<String, String> memberHash = memberArray.get(i);
						if (memberHash.get("id").equals(id)) {
							System.out.print("ȸ�����̵�\tȸ���н�����\tȸ���ּ�\tȸ����ȭ��ȣ\n");
							System.out.print(memberHash.get("id") + "\t" + memberHash.get("passwd") + "\t\t"
									+ memberHash.get("address") + "\t" + memberHash.get("tel") + "\n");
						}
					}
				} else if (protocol.equals("I") | protocol.equals("i")) { // �α���
					System.out.print("���̵� �Է�: ");
					String id = br.readLine();
					System.out.print("�н����� �Է�: ");
					String passwd = br.readLine();
					if (memberArray.size() == 0) {
						System.out.println("ȸ���� �Ѹ� �����ϴ�.");
					} else {
						for (int i = 0; i < memberArray.size(); i++) {
							HashMap<String, String> memberHash = memberArray.get(i);

							if (memberHash.get("id").equals(id) && memberHash.get("passwd").equals(passwd)) {
								System.out.println("ȯ���մϴ�. �α��� �Ǿ����ϴ�.");
								session = memberHash.get(id);
							} else if (!memberHash.get("id").equals(id) && memberHash.get("passwd").equals(passwd)) {
								System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
								return;

							} else if (memberHash.get("id").equals(id) && !memberHash.get("passwd").equals(passwd)) {
								System.out.println("�н����尡 Ʋ�Ƚ��ϴ�.");
								return;

							} else if (!memberHash.get("id").equals(id) && !memberHash.get("passwd").equals(passwd)) {
								System.out.println("���̵�,�н����� �� �� Ʋ�Ƚ��ϴ�.");
								return;
							}

						}
					}
				} else if (protocol.equals("O") | protocol.equals("o")) { // �α׾ƿ�
					if (session == null) {
						System.out.println("�α����ϼ���.");
						continue;
					}
					System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
					session = null;

				} else if (protocol.equals("D") | protocol.equals("d")) { // ȸ��Ż��
					if (session == null) {
						System.out.println("�α����ϼ���.");
						continue;
					}
					for (int i = 0; i < memberArray.size(); i++) {
						HashMap<String, String> memberHash = memberArray.get(i);
						if (memberHash.get("id").equals(session)) {
							memberArray.remove(i);
						}
					}
					session = null;
					System.out.println("ȸ��Ż�� �Ǿ����ϴ�.");
				} else if (protocol.equals("E") | protocol.equals("e")) { // ȸ������
					if (session == null) {
						System.out.println("�α����ϼ���.");
						continue;
					}
					for (int i = 0; i < memberArray.size(); i++) {
						HashMap<String, String> memberHash = memberArray.get(i);
						if (memberHash.get("id").equals(session)) {
							System.out.print(memberHash.get("id") + "\t" + memberHash.get("passwd") + "\t\t"
									+ memberHash.get("address") + "\t" + memberHash.get("tel") + "\n");

							System.out.print("���̵� �Է�: ");
							String id = br.readLine();
							System.out.print("�н����� �Է�: ");
							String passwd = br.readLine();
							System.out.print("�ּ� �Է�: ");
							String address = br.readLine();
							System.out.print("��ȭ��ȣ �Է�: ");
							String tel = br.readLine();

							memberHash.put("id", id);
							memberHash.put("passwd", passwd);
							memberHash.put("address", address);
							memberHash.put("tel", tel);
							memberArray.set(i, memberHash);

							session = memberHash.get("id");
							System.out.println("ȸ������ �Ͽ����ϴ�.");
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
