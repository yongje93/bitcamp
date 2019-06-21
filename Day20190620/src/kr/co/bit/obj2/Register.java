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
		System.out.println("학생등록");
		System.out.println("나이: ");
		age = input.next();
		System.out.println("이름: ");
		name = input.next();
		System.out.println("학번: ");
		hakbun = input.next();
		System.out.println("구분: ");
		gubun = input.next();
	}

	public void setProfessor() {
		System.out.println("교수등록");
		System.out.println("나이: ");
		age = input.next();
		System.out.println("이름: ");
		name = input.next();
		System.out.println("과목: ");
		subject = input.next();
		System.out.println("구분: ");
		gubun = input.next();
	}

	public void setManager() {
		System.out.println("관리자등록");
		System.out.println("나이: ");
		age = input.next();
		System.out.println("이름: ");
		name = input.next();
		System.out.println("부서: ");
		part = input.next();
		System.out.println("구분: ");
		gubun = input.next();
	}

	public void registerProcess(int protocol) { // 등록
		if (protocol == 1) {
			HashMap<String, String> haksaHash = new HashMap<String, String>();
			setStudent();

			haksaHash.put("age", age);
			haksaHash.put("name", name);
			haksaHash.put("hakbun", hakbun);
			haksaHash.put("gubun", gubun); // 1번 학생, 2번 교수, 3번 관리자 구분하기 위한 키.
			haksaList.add(haksaHash);

			System.out.println("학생이 등록 되었습니다.");

		} else if (protocol == 2) {
			HashMap<String, String> haksaHash = new HashMap<String, String>();
			setProfessor();

			haksaHash.put("age", age);
			haksaHash.put("name", name);
			haksaHash.put("subject", subject);
			haksaHash.put("gubun", gubun);
			haksaList.add(haksaHash);

			System.out.println("교수 등록 되었습니다.");

		} else if (protocol == 3) {
			HashMap<String, String> haksaHash = new HashMap<String, String>();
			setManager();

			haksaHash.put("age", age);
			haksaHash.put("name", name);
			haksaHash.put("part", part);
			haksaHash.put("gubun", "gubun");
			haksaList.add(haksaHash);

			System.out.println("관리자 등록 되었습니다.");
		}
	}

}
