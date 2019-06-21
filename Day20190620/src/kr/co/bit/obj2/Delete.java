package kr.co.bit.obj2;

import java.util.HashMap;

public class Delete {
	private String nameDelete;
	private String gubun;

	public Delete() {
		nameDelete = null;
		gubun = null;
	}

	public void setDeleteName() {
		System.out.println("삭제할 이름 입력..");
		nameDelete = Register.input.next();
	}

	public void setDeleteGubun() {
		System.out.println("1.학생 2.교수 3.관리자");
		gubun = Register.input.next();
	}

	public void deleteProcess() {
		setDeleteName();
		setDeleteGubun();

		for (int i = 0; i < Register.haksaList.size(); i++) {
			HashMap<String, String> haksaHash = Register.haksaList.get(i);

			if (haksaHash.get("gubun").equals("1")) {
				if (nameDelete.equals(haksaHash.get("name"))) {
					Register.haksaList.remove(i);
					System.out.println("학생 " + nameDelete + " 님이 삭제되었습니다.");
				}
			} else if (haksaHash.get("gubun").equals("2")) {
				if (nameDelete.equals(haksaHash.get("name"))) {
					Register.haksaList.remove(i);
					System.out.println("교수 " + nameDelete + " 님이 삭제되었습니다.");
				}
			} else if (haksaHash.get("gubun").equals("3")) {
				if (nameDelete.equals(haksaHash.get("name"))) {
					Register.haksaList.remove(i);
					System.out.println("관리자 " + nameDelete + " 님이 삭제되었습니다.");
				}
			}
		}
	}
}
