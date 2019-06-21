package kr.co.bit.obj2;

import java.util.HashMap;

public class Search {
	private String nameSearch;

	public Search() {
		nameSearch = null;
	}

	public void setSearchName() {
		System.out.println("이름을 입력하세요..");
		nameSearch = Register.input.next();
	}

	public void dispSearchStudent(HashMap<String, String> haksaHash) {
		System.out.println("나이\t이름\t학번");
		System.out.print(haksaHash.get("age") + "\t");
		System.out.print(haksaHash.get("name") + "\t");
		System.out.print(haksaHash.get("hakbun") + "\n");
	}

	public void dispSearchProfessor(HashMap<String, String> haksaHash) {
		System.out.println("나이\t이름\t과목");
		System.out.print(haksaHash.get("age") + "\t");
		System.out.print(haksaHash.get("name") + "\t");
		System.out.print(haksaHash.get("subject") + "\n");
	}
	
	public void dispSearhManager(HashMap<String, String> haksaHash) {
		System.out.println("나이\t이름\t부서");
		System.out.print(haksaHash.get("age") + "\t");
		System.out.print(haksaHash.get("name") + "\t");
		System.out.print(haksaHash.get("part") + "\n");	
	}

	public void searchProcess() {
		System.out.println("찾기");
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
