package kr.co.bit;

import java.util.Scanner;

public class SearchMain {
	
	public static void main(String[] args) {
		SearchService sv = new SearchService();
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("�˻��� ȸ�� �̸��� �Է��ϼ���.");
			String name = input.next();
			boolean searchResult = sv.searchMember(name);
			if(searchResult) break;
			System.out.println("�ش�ȸ���� �����ϴ�.");
		} while(true);
	}
	
}
