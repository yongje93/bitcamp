package kr.co.bit.obj2;

import java.util.HashMap;

public class List {
	
	 public void dispList() {
		  System.out.println("��ü���");
		  System.out.print("����\t�̸�\t�й�\t����\t�μ�\n");
		 }
	
	public void listProcess() {
		dispList();
		
		for (int i = 0; i < Register.haksaList.size(); i++) {
			HashMap<String, String> haksaHash = Register.haksaList.get(i);

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
	}

}
