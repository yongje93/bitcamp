package kr.co.bit.obj2;

import java.util.HashMap;

public class Search {
	private String nameSearch;

	public Search() {
		nameSearch = null;
	}

	public void setSearchName() {
		System.out.println("�̸��� �Է��ϼ���..");
		nameSearch = Register.input.next();
	}

	public void dispSearchStudent(HashMap<String, String> haksaHash) {
		System.out.println("����\t�̸�\t�й�");
		System.out.print(haksaHash.get("age") + "\t");
		System.out.print(haksaHash.get("name") + "\t");
		System.out.print(haksaHash.get("hakbun") + "\n");
	}

	public void dispSearchProfessor(HashMap<String, String> haksaHash) {
		System.out.println("����\t�̸�\t����");
		System.out.print(haksaHash.get("age") + "\t");
		System.out.print(haksaHash.get("name") + "\t");
		System.out.print(haksaHash.get("subject") + "\n");
	}
	
	public void dispSearhManager(HashMap<String, String> haksaHash) {
		System.out.println("����\t�̸�\t�μ�");
		System.out.print(haksaHash.get("age") + "\t");
		System.out.print(haksaHash.get("name") + "\t");
		System.out.print(haksaHash.get("part") + "\n");	
	}

	public void searchProcess() {
		System.out.println("ã��");
		setSearchName();
		
		for (int i = 0; i < Register.haksaList.size(); i++) {
			HashMap<String, String> haksaHash = Register.haksaList.get(i);
			if (haksaHash.get("gubun").equals("1")) {
				if (nameSearch.equals(haksaHash.get("name"))) {
					dispSearchStudent(haksaHash);
				}
			} else if (haksaHash.get("gubun").equals("2")) {
				if (nameSearch.equals(haksaHash.get("name"))) {
					dispSearchProfessor(haksaHash);
				}
			} else if (haksaHash.get("gubun").equals("3")) {
				if (nameSearch.equals(haksaHash.get("name"))) {
					dispSearhManager(haksaHash);
				}
			}
		}
	}
}
