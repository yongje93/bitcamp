package kr.co.bit.obj2;

import java.util.HashMap;

public class List {
	
	 public void dispList() {
		  System.out.println("전체출력");
		  System.out.print("나이\t이름\t학번\t과목\t부서\n");
		 }
	
	public void listProcess() {
		dispList();
		
		for (int i = 0; i < Register.haksaList.size(); i++) {
			HashMap<String, String> haksaHash = Register.haksaList.get(i);

			if (haksaHash.get("gubun").equals("1")) { // 학생출력
				System.out.print(haksaHash.get("age") + "\t");
				System.out.print(haksaHash.get("name") + "\t");
				System.out.print(haksaHash.get("hakbun") + "\n");

			} else if (haksaHash.get("gubun").equals("2")) { // 교수출력
				System.out.print(haksaHash.get("age") + "\t");
				System.out.print(haksaHash.get("name") + "\t\t");
				System.out.print(haksaHash.get("subject") + "\n");

			} else if (haksaHash.get("gubun").equals("3")) { // 관리자출력
				System.out.print(haksaHash.get("age") + "\t");
				System.out.print(haksaHash.get("name") + "\t\t\t");
				System.out.print(haksaHash.get("part") + "\n");
			}
		}
	}

}
