package kr.co.bit.obj2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Register {
	public static Scanner input;
	private int protocol;
	public static ArrayList<HashMap<String, String>> haksaList;

	private String age;
	private String name;
	private String hakbun;
	private String subject;
	private String part;
	private String gubun;

	public Register() {
		protocol = 0;
		age = null;
		name = null;
		hakbun = null;
		subject = null;
		part = null;
		gubun = null;
	}

	static {
		input = new Scanner(System.in);
		haksaList = new ArrayList<HashMap<String, String>>();
	}

	public void setStudent() {
		System.out.println("�л����");
		System.out.println("����: ");
		age = input.next();
		System.out.println("�̸�: ");
		name = input.next();
		System.out.println("�й�: ");
		hakbun = input.next();
		System.out.println("����: ");
		gubun = input.next();
	}

	public void setProfessor() {
		System.out.println("�������");
		System.out.println("����: ");
		age = input.next();
		System.out.println("�̸�: ");
		name = input.next();
		System.out.println("����: ");
		subject = input.next();
		System.out.println("����: ");
		gubun = input.next();
	}

	public void setManager() {
		System.out.println("�����ڵ��");
		System.out.println("����: ");
		age = input.next();
		System.out.println("�̸�: ");
		name = input.next();
		System.out.println("�μ�: ");
		part = input.next();
		System.out.println("����: ");
		gubun = input.next();
	}

	public void registerProcess(int protocol) { // ���
		if (protocol == 1) {
			HashMap<String, String> haksaHash = new HashMap<String, String>();
			setStudent();

			haksaHash.put("age", age);
			haksaHash.put("name", name);
			haksaHash.put("hakbun", hakbun);
			haksaHash.put("gubun", gubun); // 1�� �л�, 2�� ����, 3�� ������ �����ϱ� ���� Ű.
			haksaList.add(haksaHash);

			System.out.println("�л��� ��� �Ǿ����ϴ�.");

		} else if (protocol == 2) {
			HashMap<String, String> haksaHash = new HashMap<String, String>();
			setProfessor();

			haksaHash.put("age", age);
			haksaHash.put("name", name);
			haksaHash.put("subject", subject);
			haksaHash.put("gubun", gubun);
			haksaList.add(haksaHash);

			System.out.println("���� ��� �Ǿ����ϴ�.");

		} else if (protocol == 3) {
			HashMap<String, String> haksaHash = new HashMap<String, String>();
			setManager();

			haksaHash.put("age", age);
			haksaHash.put("name", name);
			haksaHash.put("part", part);
			haksaHash.put("gubun", "gubun");
			haksaList.add(haksaHash);

			System.out.println("������ ��� �Ǿ����ϴ�.");
		}
	}

}
